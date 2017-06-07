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
    private boolean uspesno;
    private String zadataRec;
    private int brojPokusaja;
    boolean kraj;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String poruka, boolean uspesno, String zadataRec, int brojPokusaja) {
        this.poruka = poruka;
        this.uspesno = uspesno;
        this.zadataRec = zadataRec;
        this.brojPokusaja = brojPokusaja;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public String getZadataRec() {
        return zadataRec;
    }

    public void setZadataRec(String zadataRec) {
        this.zadataRec = zadataRec;
    }

    public int getBrojPokusaja() {
        return brojPokusaja;
    }

    public void setBrojPokusaja(int brojPokusaja) {
        this.brojPokusaja = brojPokusaja;
    }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }
    
    
    
}
