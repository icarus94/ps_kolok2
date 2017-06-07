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
    
    int operacija;
    Object objekatIzvrsenjaOperacije;

    public OdgovorServera() {
    }

    public OdgovorServera(int operacija, Object objekatIzvrsenjaOperacije) {
        this.operacija = operacija;
        this.objekatIzvrsenjaOperacije = objekatIzvrsenjaOperacije;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getObjekatIzvrsenjaOperacije() {
        return objekatIzvrsenjaOperacije;
    }

    public void setObjekatIzvrsenjaOperacije(Object objekatIzvrsenjaOperacije) {
        this.objekatIzvrsenjaOperacije = objekatIzvrsenjaOperacije;
    }
    
    
    
}
