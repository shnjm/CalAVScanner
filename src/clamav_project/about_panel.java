/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author nijum
 */
public class about_panel extends JPanel {
    
    JFrame frame;
    
    
    
    about_panel(JFrame fr)
    {
        frame=fr;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        JTabbedPane pane=new JTabbedPane();
        
        Use panel1=new Use();
        Credit panel2=new Credit();
        
        pane.addTab("Use", panel1);
        pane.addTab("credit", panel2);
        
        this.add(pane);
        
        //JPanel panel=new JPanel();
        
        //panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JButton button=new JButton("Ok");
        button.addActionListener(new Action());
        //panel.add(button);
        
        this.add(button);
        
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
