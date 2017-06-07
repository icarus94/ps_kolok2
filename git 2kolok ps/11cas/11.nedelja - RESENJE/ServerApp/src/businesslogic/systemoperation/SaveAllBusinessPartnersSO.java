/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.PoslovniPartner;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class SaveAllBusinessPartnersSO extends AbstractSystemOperation {

    public SaveAllBusinessPartnersSO(DBBroker dBBroker) {
        super(dBBroker);
    }

    @Override
    protected void validate(Object object) {

    }

    @Override
    protected void checkPreCondition(Object object) {

    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<PoslovniPartner> partneri = (List<PoslovniPartner>) object;
        for (PoslovniPartner poslovniPartner : partneri) {
            try {
                dBBroker.sacuvajPoslovnogPartnera(poslovniPartner);
            } catch (Exception ex) {
                System.out.println("Greska kod cuvanja:" + poslovniPartner.getNaziv());
                throw new Exception("Greska kod cuvanja liste partnera!");
            }
        }

    }

}
