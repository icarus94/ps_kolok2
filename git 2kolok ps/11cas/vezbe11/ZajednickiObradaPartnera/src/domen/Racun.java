/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author student
 */
public class Racun implements Serializable{
    
    private int brojRacuna;
    private Date datum;
    private Double ukupno;
    
    private List<StavkaRacuna> stavke;

    public Racun() {
        stavke = new ArrayList<>();
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Double getUkupno() {
        return ukupno;
    }

    public void setUkupno(Double ukupno) {
        this.ukupno = ukupno;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }
    
    
    
    
    
    
}
