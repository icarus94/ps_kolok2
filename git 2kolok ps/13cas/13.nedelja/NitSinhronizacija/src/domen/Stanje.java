/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Stanje {

    private int kolicina;
    private boolean signal;

    public Stanje(int kolicina) {
        this.kolicina = kolicina;
        signal = true;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public synchronized void smanji(int kolicina) {
//        if (signal == false) {
        this.kolicina -= kolicina;
        System.out.println("Smanjeno je za " + kolicina + ", trenutna kolicina je:"
                + this.kolicina);
        try {
            notify();
            wait();

        } catch (InterruptedException ex) {
            Logger.getLogger(Stanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        notify();
        //            signal = true;
//        }
    }

    public synchronized void povecaj(int kolicina) {
//        if (signal == true) {
        this.kolicina += kolicina;
        System.out.println("Povecano je za " + kolicina + ", trenutna kolicina je:"
                + this.kolicina);
        try {
            notify();
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Stanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        notify();
        //            signal = false;
//        }
    }
}
