/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student
 */
public class Konekcija {    
   private static Konekcija objekat;
   private Connection konekcija;

    private Konekcija() throws SQLException, IOException {
        DBUtil dbutil = new DBUtil();
        String url = dbutil.vratiDBURL();
        String user = dbutil.vratiDBKorisnik();
        String password = dbutil.vratiDBSifra();
        konekcija = DriverManager.getConnection(url, user, password);
    }
   
   
   public Connection vratiKonekciju(){
       return konekcija;
   }
   
   
    public static Konekcija vratiObjekat() throws SQLException, IOException {
        if(objekat==null){
          objekat= new Konekcija();
        }
        return objekat;
    }
   
}
