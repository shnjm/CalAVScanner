/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ClearVirus extends JPanel {

    JFrame frame;
    Error_box errorb;
    JTable table;
    JScrollPane sp;
    JComboBox<String>[] comb;
    String[] table_head = {"File", "Type", "Action"};
    String[] actions = {"Do Nothing.", "Quarantine", "Delete"};

    ClearVirus(JFrame a, Error_box eb) {
        frame = a;
        errorb = eb;
        if (errorb.size() == 0) {
            this.setLayout(new GridLayout(5, 1));
            JLabel label = new JLabel("NO Problem(s) found...");
            label.setFont(new Font("Sherif", Font.BOLD, 20));
            JLabel label2 = new JLabel("You can proceed...");
            label2.setFont(new Font("Sherif", Font.BOLD, 20));
            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(label2);
            this.add(panel);
            this.add(new JPanel());
            this.add(new JPanel());
            this.add(new JPanel());
            JButton ok = new JButton("    OK    ");
            ok.addActionListener(new Action("OK"));
            ok.setFont(new Font("Sherif", Font.BOLD, 20));
            JPanel panel2 = new JPanel();
            panel2.add(ok);
            this.add(panel2);

        } else {
            //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setLayout(new BorderLayout());
            JLabel label1 = new JLabel("There is some Priblem(s) to solve...");
            label1.setFont(new Font("Sherif", Font.BOLD, 15));
            JPanel panel1 = new JPanel();
            panel1.add(label1);
            this.add(panel1, BorderLayout.NORTH);

            int size = eb.size();
            comb = new JComboBox[size];

            JPanel prblm = new JPanel();
            //prblm.setLayout(new BoxLayout(prblm,BoxLayout.Y_AXIS));
            prblm.setLayout(new GridLayout(0, 1));
            for (int i = 0; i < size; i++) {
                JPanel tmp = new JPanel();
                tmp.setLayout(new GridLayout(4, 1));
                tmp.add(new JLabel("File " + (i + 1) + "------------------------------------------------------------------"));
                tmp.add(new JLabel("Name: " + eb.pop(i).name));
                tmp.add(new JLabel("Type: " + eb.pop(i).type));
                comb[i] = new JComboBox(actions);
                comb[i].setSelectedIndex(0);
                tmp.add(comb[i]);
                //tmp.add(new JSeparator(SwingConstants.HORIZONTAL));
                prblm.add(tmp);

            }

            sp = new JScrollPane(prblm);
            JPanel x = new JPanel();
            x.setLayout(new GridLayout(1, 1));
            x.add(sp);
            this.add(x, BorderLayout.CENTER);

            JPanel actn_pnl = new JPanel();
            actn_pnl.setLayout(new GridLayout(1, 2));
            JButton exe_bt = new JButton("Execute");
            JButton cancel_bt = new JButton("Cancel");
            exe_bt.addActionListener(new Action("Execute"));
            cancel_bt.addActionListener(new Action("Cancel"));

            actn_pnl.add(exe_bt);
            actn_pnl.add(cancel_bt);
            this.add(actn_pnl, BorderLayout.SOUTH);

        }
    }

    void new_panel() {
        this.removeAll();

        this.setLayout(new GridLayout(5, 1));
        JLabel label = new JLabel("All Action runned...");
        label.setFont(new Font("Sherif", Font.BOLD, 20));
        JLabel label2 = new JLabel("You can proceed...");
        label2.setFont(new Font("Sherif", Font.BOLD, 20));
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(label2);
        this.add(panel);
        this.add(new JPanel());
        this.add(new JPanel());
        this.add(new JPanel());
        JButton ok = new JButton("    OK    ");
        ok.addActionListener(new Action("OK"));
        ok.setFont(new Font("Sherif", Font.BOLD, 20));
        JPanel panel2 = new JPanel();
        panel2.add(ok);
        this.add(panel2);
        frame.setVisible(true);
    }

    class Action implements ActionListener {

        String type;

        Action(String a) {
            type = a;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (type.equals("OK") || type.equals("Cancel")) {
                frame.setContentPane(new main_panel(frame));
                frame.setVisible(true);
            } else if (type.equals("Execute")) {
                int size = errorb.size();
                for (int i = 0; i < size; i++) {
                    try {
                        File f = new File(errorb.pop(i).name);
                        if (comb[i].getSelectedIndex() == 1) {
                            f.renameTo(new File(errorb.pop(i).name + ".vir_qur"));
                        } else if (comb[i].getSelectedIndex() == 2) {
                            f.delete();
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
                new_panel();
            }
        }

    }

}
