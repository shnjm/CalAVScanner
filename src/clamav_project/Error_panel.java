/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clamav_project;

import javax.swing.*;
import java.awt.*;

public class Error_panel extends JPanel{
    
    JTable table;
    JScrollPane sp;
    String[] table_head={"File","Type"};
    String[][] table_init={{"",""}};
    Error_box errB;
    
    
    Error_panel(Error_box eb)
    {
        errB=eb;
        
        table=new JTable(table_init,table_head);
        table.setCellSelectionEnabled(false);
        table.setDragEnabled(false);
        table.setShowGrid(false);
        showIt();
    }
    
    void updateTable()
    {
        int size=errB.size();
        String[][] table_data=new String[size][2];
        
        for(int i=0;i<size;i++)
        {
            table_data[i][0]=errB.pop(i).name;
            table_data[i][1]=errB.pop(i).type;
        }
        
        table=new JTable(table_data,table_head);
        table.setCellSelectionEnabled(false);
        table.setDragEnabled(false);
        table.setShowGrid(false);
        
        
        showIt();
    }
    
    private void showIt()
    {
        this.setLayout(new GridLayout(1,1));
        sp=new JScrollPane(table);
        sp.setSize(100, 100);
        this.removeAll();
        this.add(sp);
        this.updateUI();
    }
    
}
