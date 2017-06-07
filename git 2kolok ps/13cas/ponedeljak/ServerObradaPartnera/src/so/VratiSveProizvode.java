/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Proizvod;
import java.util.List;

/**
 *
 * @author student
 */
public class VratiSveProizvode extends OpstaSO{

    
    List listaProizvoda;
    
    @Override
    public void proveriPreduslovSO() {
            System.out.println("SVE JE OK, NEMA PREDUSLOVA");        
    }

    @Override
    public void konkretnoIzvrsenjeSO() throws Exception {
        
        //listaProizvoda = dbbr.vratiSveProizvode();
        listaProizvoda = dbbr.vratiSveObjekte(new Proizvod());
        
    }
    
    public List<Proizvod> vratiProizvode(){
        
         return listaProizvoda;   
    }
    
}
