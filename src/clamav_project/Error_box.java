/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import java.util.*;

public class Error_box {
    
    Vector<Error> vector;
    
    Error_box()
    {
        vector=new Vector<Error>();
    }
    
    int size()
    {
        return vector.size();
    }
    void push(Error er)
    {
        vector.add(er);
    }
    Error pop(int i)
    {
        return vector.get(i);
    }
}
