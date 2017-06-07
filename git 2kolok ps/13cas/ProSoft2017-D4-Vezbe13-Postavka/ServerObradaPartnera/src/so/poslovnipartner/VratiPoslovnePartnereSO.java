/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.poslovnipartner;

import domen.PoslovniPartner;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author student
 */
public class VratiPoslovnePartnereSO extends OpstaSO {
    
    private List<PoslovniPartner> partneri;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova za vracanje liste partnera.");
    }

    @Override
    protected void izvrsiOperaciju(Object o) throws Exception {
        partneri = dbbr.vratiSvePartnere();
    }

    public List<PoslovniPartner> getPartneri() {
        return partneri;
    }
    
}
