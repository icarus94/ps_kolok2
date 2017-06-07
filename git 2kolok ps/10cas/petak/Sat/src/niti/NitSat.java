/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author student
 */
public class NitSat extends Thread {

    JLabel labela;
    boolean kraj;

    public NitSat(JLabel labela) {
        this.labela = labela;
        kraj = false;
    }

    public void zaustavi() {
        kraj = true;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Date datum = new Date();

                sleep(50);

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                labela.setText(sdf.format(datum));
            }
        } catch (InterruptedException ex) {
            System.out.println("Prekinuto spavanje");
        }
    }

}
