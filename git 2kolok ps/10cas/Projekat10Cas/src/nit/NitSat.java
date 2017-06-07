/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author student
 */
public class NitSat extends Thread{
    JTextField jtxtSat;

    public NitSat(JTextField jtxtSat) {
        this.jtxtSat = jtxtSat;
        start();
    }
    
    
    @Override
    public void run() {
        while(true){
        Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String vreme = sdf.format(date);
            jtxtSat.setText(vreme);
        
        }
    }
    
}
