/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author nijum
 */
public class Scanning_panel extends JPanel {

    JFrame frame;
    JProgressBar prog_bar;
    int no_file;
    String loc_file;
    Error_box errorb;
    Process process = null;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JButton start;
    JButton cancel;
    JPanel panelBt;
    JProgressBar pbar;
    Error_panel EP;
    String command="clamscan -vr ";

    Scanning_panel(JFrame fr, int nf, String lf) {
        frame = fr;
        no_file = nf;
        loc_file =lf;
        _panel();
    }

    private void _panel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Scanning " + loc_file);
        title.setFont(new Font("Sherif", Font.BOLD, 12));
        this.add(title);

        pbar = new JProgressBar(0, no_file);
        pbar.setValue(0);
        pbar.setStringPainted(true);
        this.add(pbar);

        label1 = new JLabel("Please click on start button......");
        this.add(label1);
        label2 = new JLabel("Scanned 0 out of " + no_file + " files.");
        this.add(label2);
        
        
        start = new JButton(new ImageIcon(this.getClass().getResource("res/start.png")));
        start.addActionListener(new Action("Start"));

        cancel = new JButton(new ImageIcon(this.getClass().getResource("res/cancel.png")));
        cancel.addActionListener(new Action("Cancel"));

        panelBt = new JPanel();
        panelBt.add(start);
        panelBt.add(cancel);
        panelBt.setBackground(Color.cyan);
        this.add(panelBt);

        label3 = new JLabel("Errors found: 0");
        this.add(label3);

        errorb = new Error_box();
        EP = new Error_panel(errorb);
        this.add(EP);

    }


    void removeSt() {
        panelBt.remove(start);
        this.updateUI();
    }
    
    void updateView()
    {
        EP.updateTable();
        label3.setText("Errors found: "+errorb.size());
        panelBt.setBackground(Color.red);
    }

    class Action implements ActionListener {

        String str;

        Action(String a) {
            str = a;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (str.equals("Start")) {
                label1.setText("Processing,please wait......");
                Loader ld=new Loader();
                SwingWorker wrk=ld.creatWork();
                wrk.execute();
                removeSt();
            } else if (str.equals("Cancel")) {
                if (process != null) {
                    process.destroy();
                }
                frame.setContentPane(new main_panel(frame));
                frame.setVisible(true);
            }
        }

    }

    class Loader {

        public SwingWorker creatWork() {
            return new SwingWorker<Boolean, String>() {
                int x = 0;
                ProsString pros=new ProsString();
                @Override
                protected Boolean doInBackground() throws Exception {

                    
                    try {
                        String[] cmnd={"clamscan","-vr",loc_file};
                        process = Runtime.getRuntime().exec(cmnd);
                        Scanner sc = new Scanner(process.getInputStream());
                        
                        for (; sc.hasNext();) {
                            String info = sc.nextLine();
                            publish(info);
                            /*label1.setText(info);
                            if(info.startsWith("Scanning"))
                            {
                                label2.setText("Scanned " + (++x) + " out of " + no_file);
                                pbar.setValue(x);
                            }
                            
                            if(info.endsWith("FOUND"))
                            {
                                errorb.push(pros.process(info));
                                updateView();
                            }
                            System.out.println(info);*/
                        }
                        
                    } catch (Exception ex) {

                    }

                    return true;
                }

                @Override
                protected void process(List<String> chunks) {
                    
                    for(String info:chunks)
                    {
                        label1.setText(info);
                            if(info.startsWith("Scanning"))
                            {
                                label2.setText("Scanned " + (++x) + " out of " + no_file);
                                pbar.setValue(x);
                            }
                            
                            if(info.endsWith("FOUND"))
                            {
                                errorb.push(pros.process(info));
                                updateView();
                            }
                    }

                }

                @Override
                protected void done() {
                    if(process!=null)
                    {
                        process.destroy();
                        frame.setContentPane(new ClearVirus(frame,errorb));
                        frame.setVisible(true);
                    }
                    

                }

            };
        }
    }

}
