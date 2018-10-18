/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nijum
 */
public class main_panel extends JPanel {
    JFrame frame;
    GridLayout GLayout;
    ImageIcon icon;
    Image img;
    
    main_panel(JFrame fr)
    {
        frame=fr;
        GLayout=new GridLayout(3,2);
        this.setLayout(GLayout);
        addButtons();
    }
    
    private void addButtons()
    {
        icon=new ImageIcon(this.getClass().getResource("res/scae.png"));
        img=icon.getImage();
        Image newimg1=img.getScaledInstance(195, 175, java.awt.Image.SCALE_SMOOTH);
        JButton new_button1=new JButton(new ImageIcon(newimg1));
        new_button1.setBorderPainted(false);
        new_button1.addActionListener(new Action("Scan All"));
        this.add(new_button1);
        
        icon=new ImageIcon(this.getClass().getResource("res/scfe.png"));
        img=icon.getImage();
        Image newimg2=img.getScaledInstance(195, 175, java.awt.Image.SCALE_SMOOTH);
        JButton new_button2=new JButton(new ImageIcon(newimg2));
        new_button2.setBorderPainted(false);
        new_button2.addActionListener(new Action("Scan folder"));
        this.add(new_button2);
        
        
        icon=new ImageIcon(this.getClass().getResource("res/scfie.png"));
        img=icon.getImage();
        Image newimg3=img.getScaledInstance(195, 175, java.awt.Image.SCALE_SMOOTH);
        JButton new_button3=new JButton(new ImageIcon(newimg3));
        new_button3.setBorderPainted(false);
        new_button3.addActionListener(new Action("Scan File"));
        this.add(new_button3);
        
        icon=new ImageIcon(this.getClass().getResource("res/options.png"));
        img=icon.getImage();
        Image newimg6=img.getScaledInstance(195, 175, java.awt.Image.SCALE_SMOOTH);
        JButton new_button6=new JButton(new ImageIcon(newimg6));
        new_button6.setBorderPainted(false);
        //new_button6.addActionListener(new Action("Options"));
        this.add(new_button6);
        
        
        icon=new ImageIcon(this.getClass().getResource("res/about.png"));
        img=icon.getImage();
        Image newimg7=img.getScaledInstance(195, 175, java.awt.Image.SCALE_SMOOTH);
        JButton new_button7=new JButton(new ImageIcon(newimg7));
        new_button7.setBorderPainted(false);
        new_button7.addActionListener(new Action("About"));
        this.add(new_button7);
        
        icon=new ImageIcon(this.getClass().getResource("res/exit.png"));
        img=icon.getImage();
        Image newimg8=img.getScaledInstance(195, 175, java.awt.Image.SCALE_SMOOTH);
        JButton new_button8=new JButton(new ImageIcon(newimg8));
        new_button8.setBorderPainted(false);
        new_button8.addActionListener(new Action("Exit"));
        this.add(new_button8);
        
        
    }
    
    class Action implements ActionListener{
        
        get_panel panel;
        
        Action(String type)
        {
            panel=new get_panel(type);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setContentPane(panel.get_(frame));
            frame.setVisible(true);
            
        }
        
    }
    
    
}
