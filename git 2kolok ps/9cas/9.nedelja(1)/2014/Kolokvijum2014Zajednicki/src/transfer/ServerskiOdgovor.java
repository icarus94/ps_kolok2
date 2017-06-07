/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Miroslav
 */
public class ServerskiOdgovor implements Serializable{
    private String poruka;
    private int ukupno;
    private int izbrisaniBroj;
    private boolean kraj;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String poruka, int ukupno, int izbrisaniBroj, boolean kraj) {
        this.poruka = poruka;
        this.ukupno = ukupno;
        this.izbrisaniBroj = izbrisaniBroj;
        this.kraj = kraj;
    }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public int getUkupno() {
        return ukupno;
    }

    public void setUkupno(int ukupno) {
        this.ukupno = ukupno;
    }

    public int getIzbrisaniBroj() {
        return izbrisaniBroj;
    }

    public void setIzbrisaniBroj(int izbrisaniBroj) {
        this.izbrisaniBroj = izbrisaniBroj;
    }
    
    
}
