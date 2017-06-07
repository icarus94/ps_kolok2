/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import database.DBBroker;
import domen.Mesto;
import domen.PoslovniPartner;
import domen.Proizvod;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Kontroler {

    private static List<PoslovniPartner> partneri = new ArrayList<>();

    public static List<Mesto> vratiMesta() throws IOException {
        try {       
            return DBBroker.vratiSvaMesta();
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void unesiPoslovnogPartnera(PoslovniPartner partner) throws Exception {
        try {
            DBBroker.sacuvajPoslovnogPartnera(partner);
        } catch (SQLException ex) {
            throw new Exception("Poslovni partner nije sacuvan");
        }
    }

    public static List<PoslovniPartner> vratiPartnere() throws SQLException, IOException {
        return DBBroker.vratiSvePoslovnePartnere();
    }

    public static void sacuvajPartnere(List<PoslovniPartner> partneri) throws SQLException, IOException, Exception {
        DBBroker.sacuvajPartnere(partneri);
    }

    public static List<Proizvod> vratiProizvode(){
        try {
            return DBBroker.vratiSveProizvode();
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
