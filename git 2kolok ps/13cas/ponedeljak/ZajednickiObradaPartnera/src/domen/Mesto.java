/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class Mesto implements Serializable, OpstiDomenskiObjekat{
    private long ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(long ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getPtt() {
        return ptt;
    }

    public void setPtt(long ptt) {
        this.ptt = ptt;
    }

    @Override
    public String toString() {
        return ptt + " - " + naziv ;
    }

    @Override
    public String vratiNazivTabele() {
        return "Mesto";
    }

    @Override
    public List napuniSveObjekte(ResultSet rsMesto) throws SQLException {
        List<Mesto> listaMesta = new ArrayList<>();
        
        Mesto m;
        while(rsMesto.next()){            
            m = new Mesto();
            m.setPtt(rsMesto.getLong("ptt"));
            m.setNaziv(rsMesto.getString("naziv"));            
            listaMesta.add(m);          
        }      
        
        return listaMesta;
        
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ptt+",'"+naziv+"'";
    }

    
    
}
