/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domen.Mesto;
import domen.PoslovniPartner;
import domen.Proizvod;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class DBBroker {

    public static List<Mesto> vratiSvaMesta() throws SQLException, IOException {
        List<Mesto> mesta = new ArrayList<>();
//        
        Connection konekcija = Konekcija.vratiObjekat().vratiKonekciju();
        String upit = "SELECT * FROM Mesto";
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while (rs.next()) {
            long ptt = rs.getLong("ptt");
            String naziv = rs.getString("naziv");
            Mesto mesto = new Mesto(ptt, naziv);
            mesta.add(mesto);
        }
        statement.close();
        //konekcija.close();
        return mesta;
    }
    
    public static List<Proizvod> vratiSveProizvode() throws SQLException, IOException {
        List<Proizvod> proizvodi = new ArrayList<>();
//        
        Connection konekcija = Konekcija.vratiObjekat().vratiKonekciju();
        String upit = "SELECT * FROM proizvod";
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while (rs.next()) {
            long sifra = rs.getLong("sifra");
            String naziv = rs.getString("naziv");
            double cena = rs.getDouble("cena");
            Proizvod p = new Proizvod(sifra, naziv, cena);
            proizvodi.add(p);
        }
        statement.close();
        //konekcija.close();
        return proizvodi;
    }

    public static void sacuvajPoslovnogPartnera(PoslovniPartner pp) throws SQLException, IOException {

        //String url = "jdbc:mysql://localhost:3306/prosoft";
        //String user = "root";
        //String password = "";
        //Connection konekcija = DriverManager.getConnection(url, user, password);
        Connection konekcija = Konekcija.vratiObjekat().vratiKonekciju();
        String upit = "INSERT INTO poslovni_partner VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        try {
            ps.setString(1, pp.getMaticniBroj());
            ps.setString(2, pp.getPib());
            ps.setString(3, pp.getNaziv());
            ps.setString(4, pp.getUlica());
            ps.setString(5, pp.getBroj());
            ps.setLong(6, pp.getMesto().getPtt());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw sqle;
        } finally {
            ps.close();
            // konekcija.close();
        }
    }

    public static List<PoslovniPartner> vratiSvePoslovnePartnere() throws SQLException, IOException {
        List<PoslovniPartner> partneri = new ArrayList<>();
//        String url = "jdbc:mysql://localhost:3306/prosoft";
//        String user = "root";
//        String password = "";
//        Connection konekcija = DriverManager.getConnection(url, user, password);

        Connection konekcija = Konekcija.vratiObjekat().vratiKonekciju();

        String upit = "SELECT maticniBroj,pib,p.naziv,ulica,broj,m.ptt,m.naziv AS mesto FROM poslovni_partner p INNER JOIN mesto m ON p.ptt=m.ptt";
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while (rs.next()) {
            String maticniBroj = rs.getString("maticniBroj");
            String pib = rs.getString("pib");
            String naziv = rs.getString("naziv");
            String ulica = rs.getString("ulica");
            String broj = rs.getString("broj");
            long ptt = rs.getLong("ptt");
            String nazivMesta = rs.getString("mesto");
            Mesto mesto = new Mesto(ptt, nazivMesta);
            PoslovniPartner partner = new PoslovniPartner(pib, maticniBroj, naziv, ulica, broj, mesto);
            partneri.add(partner);
        }
        statement.close();
        //konekcija.close();
        return partneri;
    }

    public static void sacuvajPartnere(List<PoslovniPartner> partneri) throws SQLException, IOException, Exception {
        Connection konekcija = Konekcija.vratiObjekat().vratiKonekciju();
        konekcija.setAutoCommit(false);
        String upit = "INSERT INTO poslovni_partner VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        try {
            for (PoslovniPartner pp : partneri) {
                ps.setString(1, pp.getMaticniBroj());
                ps.setString(2, pp.getPib());
                ps.setString(3, pp.getNaziv());
                ps.setString(4, pp.getUlica());
                ps.setString(5, pp.getBroj());
                ps.setLong(6, pp.getMesto().getPtt());
                //try{
                ps.executeUpdate();
                //}catch(Exception e){
                //    System.out.println("Postoji "+pp.getMaticniBroj());              
                //}

            }
            konekcija.commit();
        } catch (Exception e) {
            konekcija.rollback();
            throw new Exception("Partneri nisu sacuvani!");
        } finally {
            ps.close();

        }

    }
}
