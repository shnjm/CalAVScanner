/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author nijum
 */
public class Get_scan_info {
    
    JFrame frame;
    
    Get_scan_info(JFrame fr)
    {
        frame=fr;
    }
    
    public String get_fol_loc()
    {
        JFileChooser fc=new JFileChooser();
        fc.setDialogType(0);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int state=fc.showDialog(frame, "Select a folder");
        if(state==JFileChooser.APPROVE_OPTION)
        {
            return fc.getSelectedFile().getPath();
        }
        frame.setContentPane(new main_panel(frame));
        frame.setVisible(true);
        return " ";
    }
    
    public int countFile(File dir)
    {
        int count=0;
        File[] list=dir.listFiles();
        if(list!=null)
        {
        for(File file:list)
        {
            if(file.isFile())
            {
                count++;
            }
            if(file.isDirectory())
            {
                count=count+countFile(file);
            }
        }
        }
        return count;
    }
    
    public String get_home()
    {
        return System.getProperty("user.home");
    }
    
    public String get_file_loc()
    {
        JFileChooser fc=new JFileChooser();
        fc.setDialogType(0);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int state=fc.showDialog(frame, "Select a file");
        if(state==JFileChooser.APPROVE_OPTION)
        {
            return fc.getSelectedFile().getPath();
        }
        frame.setContentPane(new main_panel(frame));
        frame.setVisible(true);
        return " ";
    }
    
}
