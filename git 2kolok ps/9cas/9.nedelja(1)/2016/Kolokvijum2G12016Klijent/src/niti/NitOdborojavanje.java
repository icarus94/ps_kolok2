/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forma.KlijentskaForma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miroslav
 */
public class NitOdborojavanje extends Thread{
    int ukupano;
    KlijentskaForma kf;

    public NitOdborojavanje(int ukupano, KlijentskaForma kf) {
        this.ukupano = ukupano;
        this.kf = kf;
    }

    @Override
    public void run() {
        while (ukupano>0) {            
            ukupano--;
            kf.srediTajmer(ukupano);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitOdborojavanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
