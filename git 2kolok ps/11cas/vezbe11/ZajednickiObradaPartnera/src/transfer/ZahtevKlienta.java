/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author student
 */
public class ZahtevKlienta implements Serializable{
    
    public static final int VRATI_SVE_PROIZVODE=1;
    public static final int VRATI_SVA_MESTA=3;
    public static final int SACUVAJ_PARTNERA=4;
    public static final int VRATI_SVE_POSLOVNE_PARTNERE=5;
    public static final int SACUVAJ_LISTU_POSLOVNIH_PARTNERA=6;
    
    
    int operacija;
    Object objekatOperacije;

    public ZahtevKlienta() {
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getObjekatOperacije() {
        return objekatOperacije;
    }

    public void setObjekatOperacije(Object objekatOperacije) {
        this.objekatOperacije = objekatOperacije;
    }
    
    
    
    
}
