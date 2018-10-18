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
public class Header_panel extends JPanel {
    
    JFrame frame;
    
    Header_panel(JFrame fr)
    {
        this.setLayout(new FlowLayout());
        frame=fr;
        JButton button=new JButton("Back");
        button.addActionListener(new Action());
        this.add(button);
        this.setSize((int)this.getParent().getSize().getWidth(), (int)button.getSize().getHeight());
    }
    
    class Action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setContentPane(new main_panel(frame));
            frame.setVisible(true);
        }
        
    }
    
}
