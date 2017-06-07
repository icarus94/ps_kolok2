/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forma.KlijentskaForma;
import komunikacija.KomunikacijaSaServerom;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class CekajOdgovorOdServera extends Thread{
    KlijentskaForma kf;

    public CekajOdgovorOdServera(KlijentskaForma kf) {
        this.kf = kf;
    }

    @Override
    public void run() {
        
        while (true) {            
            ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().vratiOdgovor();
        
            if(so.isPocelaIgra()){
                if(so.isKrajIgre()){
                    kf.zavrsiIGru(so);
                }else{
                    kf.srediFormu(so);
                }
            }else{
                kf.nijePocelaIGra();
            }
        }
        
    }
    
    
}
