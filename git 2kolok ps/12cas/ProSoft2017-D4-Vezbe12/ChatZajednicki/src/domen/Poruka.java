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
public class Poruka implements Serializable{
    
    private String odKogajePoruka;
    private String zaKogaJePoruka;
    
    private String poruka;

    public Poruka() {
    }

    public Poruka(String odKogajePoruka, String zaKogaJePoruka, String poruka) {
        this.odKogajePoruka = odKogajePoruka;
        this.zaKogaJePoruka = zaKogaJePoruka;
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getOdKogajePoruka() {
        return odKogajePoruka;
    }

    public void setOdKogajePoruka(String odKogajePoruka) {
        this.odKogajePoruka = odKogajePoruka;
    }

    public String getZaKogaJePoruka() {
        return zaKogaJePoruka;
    }

    public void setZaKogaJePoruka(String zaKogaJePoruka) {
        this.zaKogaJePoruka = zaKogaJePoruka;
    }
    
    
    
}
