/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import businesslogic.systemoperation.AbstractSystemOperation;
import businesslogic.systemoperation.GetAllPlacesSO;
import businesslogic.systemoperation.SaveAllBusinessPartnersSO;
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

    public static List<Mesto> vratiMesta() throws Exception {
        try {
            GetAllPlacesSO so = new GetAllPlacesSO(new DBBroker());
            so.execute(null);
            return so.getMesta();
            //  return DBBroker.vratiSvaMesta();
        } catch (Exception ex) {
            throw new Exception("Greska kod izvrsenja metode vratiSvaMesta()");
        }

    }

    public static void unesiPoslovnogPartnera(PoslovniPartner partner) throws Exception {
        try {
            // DBBroker.sacuvajPoslovnogPartnera(partner);
        } catch (Exception ex) {
            throw new Exception("Poslovni partner nije sacuvan");
        }
    }

    public static List<PoslovniPartner> vratiPartnere() throws SQLException, IOException {
        // return DBBroker.vratiSvePoslovnePartnere();
        return null;
    }

    public static void sacuvajPartnere(List<PoslovniPartner> partneri) throws Exception {
        // DBBroker.sacuvajPartnere(partneri);
        DBBroker dBBroker = new DBBroker();
        AbstractSystemOperation so = new SaveAllBusinessPartnersSO(dBBroker);
        so.execute(partneri);
    }

    public static List<Proizvod> vratiProizvode() {
        try {
            // return DBBroker.vratiSveProizvode();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
