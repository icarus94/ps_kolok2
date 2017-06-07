/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author student
 */
public class Mesto {
    private long ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(long ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public long getPtt() {
        return ptt;
    }

    public void setPtt(long ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
   
    
}
