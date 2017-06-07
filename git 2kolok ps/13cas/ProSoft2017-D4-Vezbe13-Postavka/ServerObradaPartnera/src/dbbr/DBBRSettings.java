/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import sun.awt.FontConfiguration;

/**
 *
 * @author student
 */
public class DBBRSettings {
    
    Properties podesavanja;

    private DBBRSettings() throws FileNotFoundException, IOException {
        loadProperties();
    }
    
    private static DBBRSettings instanca;
    private String currentDB;
    
    public static DBBRSettings vratiInstancu() throws FileNotFoundException, IOException{
        if (instanca==null){
            instanca = new DBBRSettings();
        }
        return instanca;
    }

    private void loadProperties() throws FileNotFoundException, IOException {
         
        FileInputStream fis = new FileInputStream("main.properties");        
        podesavanja = new Properties();        
        podesavanja.load(fis);        
        currentDB = podesavanja.getProperty("currentDB");
    }
    
    
    public String vratiURL(){
        return podesavanja.getProperty(currentDB+"_url");
    }
    
    public String vratiUsername(){
        return podesavanja.getProperty(currentDB+"_username");
    }
    
    public String vratiPassword(){
        return podesavanja.getProperty(currentDB+"_password");
    }
    
}
