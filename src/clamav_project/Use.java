/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author nijum
 */
public class Use extends JPanel {
    Use()
    {
       JLabel h1=new JLabel("How to use...");
       h1.setFont(new Font("Sherif", Font.BOLD, 20));
       this.add(h1);
       JPanel data=new JPanel();
       data.setLayout(new BoxLayout(data,BoxLayout.Y_AXIS));
       
       JLabel h2=new JLabel("Scanning....");
       h2.setFont(new Font("Sherif",Font.BOLD,15));
       data.add(h2);
       
       data.add(new JLabel("1. Select First option to scan all the system."));
       data.add(new JLabel("2. Select second option to scan a folder recursively."));
       data.add(new JLabel("3. Select third option to scan a specific file."));
       data.add(new JLabel(" "));
       
       JLabel h2_1=new JLabel("Actions on virus...");
       h2_1.setFont(new Font("Sherif",Font.BOLD,15));
       data.add(h2_1);
       
       data.add(new JLabel("Select action from drop down list for each problem & execute it."));
       data.add(new JLabel(" "));
       
       JLabel h2_2=new JLabel("Other Options...");
       h2_2.setFont(new Font("Sherif",Font.BOLD,15));
       data.add(h2_2);
       
       data.add(new JLabel("1. \"Options\" to set various option."));
       data.add(new JLabel("2. \"About\" for usage and credits."));
       data.add(new JLabel("3. \"Exit\" to exit the program."));
       this.add(data);
    }
}
