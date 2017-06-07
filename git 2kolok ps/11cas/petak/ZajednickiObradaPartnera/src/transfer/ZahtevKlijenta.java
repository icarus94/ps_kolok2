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
public class ZahtevKlijenta implements Serializable {
    
    public static final int VRATI_SVE_PROIZVODE = 1;
    public static final int VRATI_SVE_PARTNERE = 2;
    
    
    int operacija;
    Object objekatOperacije;

    public ZahtevKlijenta() {
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
