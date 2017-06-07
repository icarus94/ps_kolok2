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
public class Proizvod {
    private long stfra;
    private String naziv;
    private double cena;

    public Proizvod() {
    }

    public Proizvod(long stfra, String naziv, double cena) {
        this.stfra = stfra;
        this.naziv = naziv;
        this.cena = cena;
    }

    public long getStfra() {
        return stfra;
    }

    public void setStfra(long stfra) {
        this.stfra = stfra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
    
           
}
