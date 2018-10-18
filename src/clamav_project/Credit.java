/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author nijum
 */
public class Credit extends JPanel {

    Credit() {
        JLabel h1 = new JLabel("CalAVScanner");
        h1.setFont(new Font("Sherif", Font.BOLD, 20));
        this.add(h1);
        this.add(new JLabel(new ImageIcon(this.getClass().getResource("res/main.pic.png"))));
        
        JPanel data=new JPanel();
        data.setLayout(new BoxLayout(data,BoxLayout.Y_AXIS));
        
        data.add(new JLabel("Name: Sakhawat Hossain Nijum"));
        data.add(new JLabel(" "));
        data.add(new JLabel("Noakhali Science and Technology University,Noakhali"));
        
        this.add(data);
    }
}
