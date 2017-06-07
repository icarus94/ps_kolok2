/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.Proizvod;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class SOVratiSveProizvode extends OpstaSO{
    private List<Proizvod> proizvodi;
    
    @Override
    protected void proveriPreduslove() throws Exception {
        //nema preduslova
    }

    @Override
    protected void izvrsi() throws Exception {
        proizvodi=dbbr.vratiSveProizvode();
    }
    
    public List<Proizvod> getProizvodi(){
        return proizvodi;
    }
    
}
