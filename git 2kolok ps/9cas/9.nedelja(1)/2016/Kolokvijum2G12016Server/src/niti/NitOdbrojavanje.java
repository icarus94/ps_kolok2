/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.ServerskaForma;
import java.util.logging.Level;
import java.util.logging.Logger;
import kom.KomunikacijaSaKlijentom;
import logika.Kontroler;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class NitOdbrojavanje extends Thread{
    ServerskaForma sf ;
    int ukupanBrojSekundi;

    public NitOdbrojavanje(ServerskaForma sf, int ukupanBrojSekundi) {
        this.sf = sf;
        this.ukupanBrojSekundi = ukupanBrojSekundi;
    }

    @Override
    public void run() {
        while (ukupanBrojSekundi>0) {  
            ukupanBrojSekundi--;
            sf.namestiTajmer(ukupanBrojSekundi);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitOdbrojavanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ServerskiOdgovor so = new ServerskiOdgovor();
            so.setBrPoenaDrugiIgrac(Kontroler.getInstance().getBrojPoenaDrugog());
            so.setPocelaIgra(true);
            so.setBrPoenaPrviIgrac(Kontroler.getInstance().getBrojPoenaPrvog());
            so.setDrugiIgrac(Kontroler.getInstance().getImeDrugog());
            so.setPrviIgrac(Kontroler.getInstance().getImePrvog());
            so.setKrajIgre(true);
            if(Kontroler.getInstance().getBrojPoenaPrvog()> Kontroler.getInstance().getBrojPoenaDrugog()){
                so.setPoruka("Pobedio je prvi igrac: "+Kontroler.getInstance().getImePrvog());
            }else{
                so.setPoruka("Pobedio je drugi igrac: "+Kontroler.getInstance().getImeDrugog()); 
            }
            
            KomunikacijaSaKlijentom.getInstance().posaljiOdgovor(so, Kontroler.getInstance().getS1());
            KomunikacijaSaKlijentom.getInstance().posaljiOdgovor(so, Kontroler.getInstance().getS2());
            
    }
    
    
    
}
