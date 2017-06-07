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
    private int oepracija;
    private String slovo;
    private String username;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int oepracija, String slovo, String username) {
        this.oepracija = oepracija;
        this.slovo = slovo;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOepracija() {
        return oepracija;
    }

    public void setOepracija(int oepracija) {
        this.oepracija = oepracija;
    }

    public String getSlovo() {
        return slovo;
    }

    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }
    
    
}
