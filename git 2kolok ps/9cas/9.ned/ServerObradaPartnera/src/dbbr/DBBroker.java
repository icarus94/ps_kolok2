/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbr;

import domen.Mesto;
import domen.PoslovniPartner;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class DBBroker {

    public DBBroker() {
    }
    
    
    Connection konekcija;
    
    
    public void uspostaviKonekciju() throws Exception{        
        //String konekcioniString = "jdbc:mysql://localhost:3306/partnerid3";
        String konekcioniString = DBBRSettings.vratiInstancu().vratiURL();
        String user = DBBRSettings.vratiInstancu().vratiUsername();
        String pass = DBBRSettings.vratiInstancu().vratiPassword();
        konekcija = DriverManager.getConnection(konekcioniString, user, pass);
        konekcija.setAutoCommit(false);
        System.out.println("USPESNA KONEKCIJA");        
    }
    
    
    public void potvrdiTransakciju() throws SQLException{
        
        konekcija.commit();
    }
    
    public void ponistiTransakciju() throws SQLException{
        
        konekcija.rollback();
    }
    
    
    
    public List<Mesto> vratiSvaMesta() throws SQLException{
        
        List<Mesto>  listaMesta = new ArrayList<>();
        
        
        Statement naredba = konekcija.createStatement();
        String upit = "SELECT * FROM MESTO";
        
        ResultSet rsMesto = naredba.executeQuery(upit);
        Mesto m;
        while(rsMesto.next()){
            
            m = new Mesto();
            m.setPtt(rsMesto.getLong("ptt"));
            m.setNaziv(rsMesto.getString("naziv"));
            
            listaMesta.add(m);            
        }
        
        
        return listaMesta;
    }
    
    
    public List<Proizvod> vratiSveProizvode() throws SQLException{
        
        List<Proizvod>  listaProizvoda = new ArrayList<>();       
        
        Statement naredba = konekcija.createStatement();
        String upit = "SELECT * FROM Proizvod";
        
        ResultSet rsProizvod = naredba.executeQuery(upit);
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
    
    
    
    
     public List<PoslovniPartner> vratiSvePartnere() throws SQLException{
        
        List<PoslovniPartner>  listaPartnera = new ArrayList<>();       
        
        Statement naredba = konekcija.createStatement();
        String upit = "SELECT * FROM PoslovniPartner p INNER JOIN MESTO m ON (p.mesto=m.ptt)";
        
        ResultSet rsPartner = naredba.executeQuery(upit);
        Mesto m;
        PoslovniPartner p;
        while(rsPartner.next()){
            
            p = new PoslovniPartner();            
            p.setMaticniBroj(rsPartner.getString("maticniBroj"));
            p.setNaziv(rsPartner.getString("naziv"));
            p.setPib(rsPartner.getString("pib"));
            p.setUlica(rsPartner.getString("ulica"));
            p.setBroj(rsPartner.getString("broj"));
                       
            
            m = new Mesto();
            m.setPtt(rsPartner.getLong("ptt"));
            m.setNaziv(rsPartner.getString("m.naziv"));
            p.setMesto(m);
            
            listaPartnera.add(p);            
        }   
        return listaPartnera;
    }
    
    
    
    
    
    
    public void sacuvajPartnera(PoslovniPartner partner) throws SQLException{
        
        
        //String upit = "INSERT INTO poslovniPartner VALUES ('"+partner.getMaticniBroj()+"','"+partner.getNaziv()+"')"......
        
        String upit = "INSERT INTO poslovniPartner VALUES (?,?,?,?,?,?)";
        
        PreparedStatement pNaredba = konekcija.prepareStatement(upit);
        
        pNaredba.setString(1, partner.getMaticniBroj());
        pNaredba.setString(2, partner.getNaziv());
        pNaredba.setString(3, partner.getPib());
        pNaredba.setString(4, partner.getUlica());
        pNaredba.setString(5, partner.getBroj());
        pNaredba.setLong(6, partner.getMesto().getPtt());
        
        pNaredba.executeUpdate();
        
    }
    
    
    
    
    
    public static void main(String[] args) {
        try {
            DBBroker dbbr = new DBBroker();
            dbbr.uspostaviKonekciju();
        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sacuvajRacun(Racun r) {
        throw new UnsupportedOperationException("NIJE JOS UVEK IMPLEMENTIRANO. IMPLEMENTIRATI."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sacuvajStavku(StavkaRacuna stavka) {
        throw new UnsupportedOperationException("NIJE JOS UVEK IMPLEMENTIRANO. IMPLEMENTIRATI."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
