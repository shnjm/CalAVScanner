/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;
import javax.swing.*;

/**
 *
 * @author nijum
 */
public class ClamAV_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
            System.out.println("UIManager Error.");
        }
        JFrame frame=new JFrame("CalAVScanner.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon(new ClamAV_project().getClass().getResource("res/main.png"));
        frame.setIconImage(icon.getImage());
        frame.setContentPane(new main_panel(frame));
        frame.setSize(375, 550);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
    
}
