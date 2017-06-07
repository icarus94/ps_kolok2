/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class Proizvod implements Serializable,OpstiDomenskiObjekat{
    
    
    int sifra;
    String naziv;
    Double cena;

    public Proizvod() {
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "Proizvod";
    }

    @Override
    public List napuniSveObjekte(ResultSet rsProizvod) throws SQLException {
        
        List<Proizvod>  listaProizvoda = new ArrayList<>();       
        
        Proizvod proizvod;
        while(rsProizvod.next()){            
            proizvod = new Proizvod();
            proizvod.setSifra(rsProizvod.getInt("sifra"));
            proizvod.setNaziv(rsProizvod.getString("naziv"));
            proizvod.setCena(rsProizvod.getDouble("cena"));            
            listaProizvoda.add(proizvod);            
        }      
        
        return listaProizvoda;
        
        
    }

    @Override
    public String vratiVrednostiZaInsert() {
       return sifra+",'"+naziv+"',"+cena;
    }
    
    
    
}
