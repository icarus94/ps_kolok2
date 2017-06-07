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
public class SOSacuvajListuPoslovnihPartnera extends OpstaSO{
    List<PoslovniPartner> partneri;
    
    public SOSacuvajListuPoslovnihPartnera(List<PoslovniPartner> partneri){
        this.partneri=partneri;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
        //preduslovi
    }

    @Override
    protected void izvrsi() throws Exception {
        for (PoslovniPartner partner : partneri) {
            dbbr.sacuvajPartnera(partner);
        }
    }
}
