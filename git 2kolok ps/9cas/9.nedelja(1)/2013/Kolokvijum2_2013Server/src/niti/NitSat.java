/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Miroslav
 */
public class NitSat extends Thread{
    JLabel labelaSat;

    public NitSat(JLabel labelaSat) {
        this.labelaSat = labelaSat;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while (true) {            
            labelaSat.setText("Sada je :   "+sdf.format(new Date()));
        }
    }
    
    
}
