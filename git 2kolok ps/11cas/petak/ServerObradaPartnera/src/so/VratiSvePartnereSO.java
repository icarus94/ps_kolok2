/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbbr.DBBroker;
import domen.PoslovniPartner;
import java.util.List;

/**
 *
 * @author student
 */
public class VratiSvePartnereSO extends OpstaSO {

    List<PoslovniPartner> listaPartnera;
    
    
    public VratiSvePartnereSO(DBBroker dbbr) {
        super(dbbr);
    }

    @Override
    public void konkretnoIzvrsenjeSO() throws Exception {
        listaPartnera = dbbr.vratiSvePartnere();
        
    }

    public List<PoslovniPartner> getListaPartnera() {
        return listaPartnera;
    }
    
    
}
