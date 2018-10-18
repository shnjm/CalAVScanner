/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import javax.swing.*;
import java.io.*;

public class get_panel {
    
    String type;
    
    get_panel(String st)
    {
        type=st;
    }
    public JPanel get_(JFrame frame)
    {
        if(type.equals("Scan All"))
        {
            Get_scan_info info=new Get_scan_info(frame);
            String loc=info.get_home();
            int num=info.countFile(new File(loc));
            if(loc.equals(" ")||num==0)
                return new main_panel(frame);
            else
                return new Scanning_panel(frame,num,loc);
        }
        else if(type.equals("Scan folder"))
        {
            Get_scan_info info=new Get_scan_info(frame);
            String loc=info.get_fol_loc();
            int num=info.countFile(new File(loc));
            if(loc.equals(" ")||num==0)
                return new main_panel(frame);
            else
                return new Scanning_panel(frame,num,loc);
        }
        else if(type.equals("Scan File"))
        {
            Get_scan_info info=new Get_scan_info(frame);
            String loc=info.get_file_loc();
            int num=1;
            if(loc.equals(" "))
                return new main_panel(frame);
            else
                return new Scanning_panel(frame,num,loc);
        }
        else if(type.equals("Options"))
        {
            return new option_panel(frame);
        }
        else if(type.equals("Exit"))
        {
            System.exit(0);
        }
        
        return new about_panel(frame);
        
    }
    
}
