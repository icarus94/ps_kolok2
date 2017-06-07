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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Mesto implements Serializable, IDomenskiObjekat {

    private long ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(long ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public long getPtt() {
        return ptt;
    }

    public void setPtt(long ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null;
    }

    @Override
    public List<IDomenskiObjekat> vratiListu(ResultSet rs) {
        List<IDomenskiObjekat> mesta = new ArrayList<>();
        try {
            while (rs.next()) {
                long ptt = rs.getLong("ptt");
                String naziv = rs.getString("naziv");
                Mesto mesto = new Mesto(ptt, naziv);
                mesta.add(mesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesta;
    }

}
