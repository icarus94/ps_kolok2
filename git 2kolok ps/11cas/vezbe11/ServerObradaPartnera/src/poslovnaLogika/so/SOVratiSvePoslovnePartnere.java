/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.PoslovniPartner;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class SOVratiSvePoslovnePartnere extends OpstaSO{
    private List<PoslovniPartner> poslovniPartneri;
    
    @Override
    protected void proveriPreduslove() throws Exception {
        //nema preduslova
    }

    @Override
    protected void izvrsi() throws Exception {
        poslovniPartneri=dbbr.vratiSvePartnere();
    }
    
    public List<PoslovniPartner> getPoslovniPartneri(){
        return poslovniPartneri;
    }
    
}
