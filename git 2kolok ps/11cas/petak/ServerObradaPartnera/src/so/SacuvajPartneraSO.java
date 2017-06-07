/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbbr.DBBroker;
import domen.PoslovniPartner;

/**
 *
 * @author student
 */
public class SacuvajPartneraSO extends OpstaSO{

    PoslovniPartner partner;
    
    public SacuvajPartneraSO(DBBroker dbbr) {
        super(dbbr);
    }

    @Override
    public void konkretnoIzvrsenjeSO() throws Exception {
        dbbr.sacuvajPartnera(partner);
    }
    
    public void setPartner(PoslovniPartner partner) {
        this.partner = partner;
    }
    
}
