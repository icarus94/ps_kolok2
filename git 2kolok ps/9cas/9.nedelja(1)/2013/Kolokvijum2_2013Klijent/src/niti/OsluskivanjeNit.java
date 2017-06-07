/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.GlavnaForma;
import kom.KomunikacijaSaServerom;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class OsluskivanjeNit extends  Thread{
    GlavnaForma gf;

    public OsluskivanjeNit(GlavnaForma gf) {
        this.gf = gf;
    }

    @Override
    public void run() {
        while (true) {            
            ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            gf.promeniPoruku(so.getPoruka());
        }
    }
    
    
}
