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
public class OdgovorServera implements Serializable{


    int signal;
    Object objekatIzvrsenjaOperacije;
    
    Exception izuzetak;

    public OdgovorServera() {
    }

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public Object getObjekatIzvrsenjaOperacije() {
        return objekatIzvrsenjaOperacije;
    }

    public void setObjekatIzvrsenjaOperacije(Object objekatIzvrsenjaOperacije) {
        this.objekatIzvrsenjaOperacije = objekatIzvrsenjaOperacije;
    }

    public Exception getIzuzetak() {
        return izuzetak;
    }

    public void setIzuzetak(Exception izuzetak) {
        this.izuzetak = izuzetak;
    }
    
    
    
    
}
