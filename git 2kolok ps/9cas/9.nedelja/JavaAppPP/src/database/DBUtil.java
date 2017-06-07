/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import util.DBKonstante;

/**
 *
 * @author student
 */
public class DBUtil {

    Properties properties;

    public DBUtil() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("db.config"));
    }

    public String vratiDBURL() {
        return properties.getProperty(DBKonstante.URL);
    }

    public String vratiDBKorisnik() {
        return properties.getProperty(DBKonstante.USER);
    }

    public String vratiDBSifra() {
        return properties.getProperty(DBKonstante.PASSWORD);
    }

}
