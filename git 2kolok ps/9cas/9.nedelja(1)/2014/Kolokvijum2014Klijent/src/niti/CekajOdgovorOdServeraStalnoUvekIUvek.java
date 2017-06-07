/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.KlijentskaForma;
import komunikacija.KomunikacijaSaServerom;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class CekajOdgovorOdServeraStalnoUvekIUvek extends Thread{
    KlijentskaForma kf;

    public CekajOdgovorOdServeraStalnoUvekIUvek(KlijentskaForma kf) {
        this.kf = kf;
    }

    @Override
    public void run() {
        while (true) {            
            ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
            
            kf.srediFormuPosleOdgovora(so);
        }
    }
    
    
}
