/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author student
 */
public class Mesto implements Serializable{
    private long ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(long ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getPtt() {
        return ptt;
    }

    public void setPtt(long ptt) {
        this.ptt = ptt;
    }

    @Override
    public String toString() {
        return ptt + " - " + naziv ;
    }

    
    
}
