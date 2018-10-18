/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

/**
 *
 * @author nijum
 */
public class ProsString {
    Error process(String str)
    {
        String name=str.substring(0, str.lastIndexOf(':'));
        String type=str.substring(str.lastIndexOf(':')).split(" ")[1];
        //System.out.println("name= "+name+"\ntype= "+type);
        
        return new Error(name,type);
    }
    
}
