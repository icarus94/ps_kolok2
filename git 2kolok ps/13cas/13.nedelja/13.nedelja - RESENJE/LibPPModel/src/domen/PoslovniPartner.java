/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author student
 */
public class PoslovniPartner implements Serializable, IDomenskiObjekat {

    private String pib;
    private String maticniBroj;
    private String naziv;
    private String ulica;
    private String broj;
    private Mesto mesto;

    public PoslovniPartner() {
    }

    public PoslovniPartner(String pib, String maticniBroj, String naziv, String ulica, String broj, Mesto mesto) {
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.naziv = naziv;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public String vratiNazivTabele() {
        return "poslovnipartner";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + getMaticniBroj() + "','" + getPib() + "','" + getNaziv() + "','"
                + getUlica() + "','" + getBroj() + "'," + mesto.getPtt();
    }

    @Override
    public List<IDomenskiObjekat> vratiListu(ResultSet rs) {
        return null;
    }

}
