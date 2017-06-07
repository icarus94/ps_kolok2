/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magacin;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Stanje {

    int stanje;
    private boolean signal = false;

    public Stanje(int stanje) {
        this.stanje = stanje;
    }

    public synchronized void smanji(int kolicina) {
        try {

            //if (signal == false) {
                
                Thread.currentThread().sleep(1000);
                stanje = stanje - kolicina;
                System.out.println("Stanje je smanjeno za " + kolicina + ", i sada je kolicina " + stanje);
                signal = true; 
                notify();
                wait();
                System.out.println("PUSTIO ME JE NEKO");
            //}
        } catch (InterruptedException ex) {
            Logger.getLogger(Stanje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getStanje() {
        return stanje;
    }
    public void setStanje(int stanje) {
        this.stanje = stanje;
    }
    public synchronized void povecaj(int kolicina) {

        try {
            //if (signal) {
                Thread.currentThread().sleep(1000);
                stanje = stanje + kolicina;
                System.out.println("Stanje je povecano za " + kolicina + ", i sada je kolicina " + stanje);
                signal = false;
                notify();
                wait();
           // }
        } catch (InterruptedException ex) {
            Logger.getLogger(Stanje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
