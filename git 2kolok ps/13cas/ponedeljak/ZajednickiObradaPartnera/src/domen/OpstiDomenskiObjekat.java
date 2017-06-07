/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author student
 */
public interface OpstiDomenskiObjekat {

    public String vratiNazivTabele();

    public List napuniSveObjekte(ResultSet rsODO) throws SQLException;

    public String vratiVrednostiZaInsert();
    
    
    
    
}
