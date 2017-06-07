/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbbr.DBBroker;
import domen.Proizvod;
import java.util.List;

/**
 *
 * @author student
 */
public class VratiSveProizvodeSO extends OpstaSO{

    List<Proizvod> listaProizvoda;

    public VratiSveProizvodeSO(DBBroker dbbr) {
        super(dbbr);
    }
    
    @Override
    public void konkretnoIzvrsenjeSO() throws Exception {
        listaProizvoda = dbbr.vratiSveProizvode();
    }

    public List<Proizvod> getListaProizvoda() {
        return listaProizvoda;
    }
    
    
}
