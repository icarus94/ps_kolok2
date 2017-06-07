/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.PoslovniPartner;

/**
 *
 * @author Korisnik
 */
public class SOSacuvajPartnera extends OpstaSO{
    private PoslovniPartner partner;
    
    public SOSacuvajPartnera(PoslovniPartner partner){
        this.partner=partner;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
        //preduslovi
    }

    @Override
    protected void izvrsi() throws Exception {
        dbbr.sacuvajPartnera(partner);
    }
    
    
}
