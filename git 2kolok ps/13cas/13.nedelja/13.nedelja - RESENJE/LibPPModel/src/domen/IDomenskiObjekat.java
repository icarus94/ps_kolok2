/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author student
 */
public interface IDomenskiObjekat {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public List<IDomenskiObjekat> vratiListu(ResultSet rs);
}
