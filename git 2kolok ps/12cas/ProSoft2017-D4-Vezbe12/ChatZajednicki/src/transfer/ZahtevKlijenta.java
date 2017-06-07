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
public class ZahtevKlijenta implements Serializable{
    
    int operacija;
    Object objekatOperacije;

    public ZahtevKlijenta() {
    }

    public ZahtevKlijenta(int operacija, Object objekatOperacije) {
        this.operacija = operacija;
        this.objekatOperacije = objekatOperacije;
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
