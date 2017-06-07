/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.Kategorija;
import domen.Korisnik;
import java.io.Serializable;

/**
 *
 * @author Miroslav
 */
public class KlijentskiZahtev implements Serializable{
    private int operacija;
    private Korisnik korisnik;
    private Kategorija kat;
    private char slovo;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Korisnik korisnik, Kategorija kat, char slovo) {
        this.operacija = operacija;
        this.korisnik = korisnik;
        this.kat = kat;
        this.slovo = slovo;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Kategorija getKat() {
        return kat;
    }

    public void setKat(Kategorija kat) {
        this.kat = kat;
    }

    public char getSlovo() {
        return slovo;
    }

    public void setSlovo(char slovo) {
        this.slovo = slovo;
    }
    
    
    
}
