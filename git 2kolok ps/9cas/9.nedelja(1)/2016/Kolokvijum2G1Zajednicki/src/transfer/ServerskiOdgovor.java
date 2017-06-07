/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.Slovo;
import java.io.Serializable;

/**
 *
 * @author Miroslav
 */
public class ServerskiOdgovor implements Serializable{
    private String poruka;
    private boolean pobednik;
    private boolean krajIgre;
    private boolean pocelaIgra;
    private String prviIgrac;
    private int brPoenaPrviIgrac;
    private String drugiIgrac;
    private int brPoenaDrugiIgrac;
    private Slovo slovo;
    int ukupnoSekundi;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String poruka, boolean pobednik, boolean krajIgre, boolean pocelaIgra, String prviIgrac, int brPoenaPrviIgrac, String drugiIgrac, int brPoenaDrugiIgrac, Slovo slovo) {
        this.poruka = poruka;
        this.pobednik = pobednik;
        this.krajIgre = krajIgre;
        this.pocelaIgra = pocelaIgra;
        this.prviIgrac = prviIgrac;
        this.brPoenaPrviIgrac = brPoenaPrviIgrac;
        this.drugiIgrac = drugiIgrac;
        this.brPoenaDrugiIgrac = brPoenaDrugiIgrac;
        this.slovo = slovo;
    }

    public Slovo getSlovo() {
        return slovo;
    }

    public void setSlovo(Slovo slovo) {
        this.slovo = slovo;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isPobednik() {
        return pobednik;
    }

    public void setPobednik(boolean pobednik) {
        this.pobednik = pobednik;
    }

    public boolean isKrajIgre() {
        return krajIgre;
    }

    public void setKrajIgre(boolean krajIgre) {
        this.krajIgre = krajIgre;
    }

    public boolean isPocelaIgra() {
        return pocelaIgra;
    }

    public void setPocelaIgra(boolean pocelaIgra) {
        this.pocelaIgra = pocelaIgra;
    }

    public String getPrviIgrac() {
        return prviIgrac;
    }

    public void setPrviIgrac(String prviIgrac) {
        this.prviIgrac = prviIgrac;
    }

    public int getBrPoenaPrviIgrac() {
        return brPoenaPrviIgrac;
    }

    public void setBrPoenaPrviIgrac(int brPoenaPrviIgrac) {
        this.brPoenaPrviIgrac = brPoenaPrviIgrac;
    }

    public String getDrugiIgrac() {
        return drugiIgrac;
    }

    public void setDrugiIgrac(String drugiIgrac) {
        this.drugiIgrac = drugiIgrac;
    }

    public int getBrPoenaDrugiIgrac() {
        return brPoenaDrugiIgrac;
    }

    public void setBrPoenaDrugiIgrac(int brPoenaDrugiIgrac) {
        this.brPoenaDrugiIgrac = brPoenaDrugiIgrac;
    }

    public int getUkupnoSekundi() {
        return ukupnoSekundi;
    }

    public void setUkupnoSekundi(int ukupnoSekundi) {
        this.ukupnoSekundi = ukupnoSekundi;
    }
    
    
}
