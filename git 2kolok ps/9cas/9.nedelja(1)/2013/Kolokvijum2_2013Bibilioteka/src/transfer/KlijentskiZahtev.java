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
public class KlijentskiZahtev implements Serializable{
    private int operacija;
    private String korisnickoIme;
    private int pozicija;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, String korisnickoIme, int pozicija) {
        this.operacija = operacija;
        this.korisnickoIme = korisnickoIme;
        this.pozicija = pozicija;
    }

    public int getPozicija() {
        return pozicija;
    }

    public void setPozicija(int pozicija) {
        this.pozicija = pozicija;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    
    
}
