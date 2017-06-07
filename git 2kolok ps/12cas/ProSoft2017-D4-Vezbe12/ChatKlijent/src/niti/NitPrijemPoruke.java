/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Poruka;
import forme.modelitabele.TableModelPoruka;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import operacije.Operacije;
import transfer.OdgovorServera;

/**
 *
 * @author student
 */
public class NitPrijemPoruke extends Thread{
    
    
    TableModelPoruka tmp;

    public NitPrijemPoruke(TableModelPoruka tmp) {
        this.tmp = tmp;
    }
    
    
    @Override
    public void run() {
        
        while(true){
            
            try {
                
                OdgovorServera odgovor = Komunikacija.vratiInstancu().procitajOdgovor();
                
                obradiOdgovorOdServera(odgovor);
                
            } catch (Exception ex) {
                Logger.getLogger(NitPrijemPoruke.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
    }

    private void obradiOdgovorOdServera(OdgovorServera odgovor) {
        switch(odgovor.getOperacija()){
            
            case Operacije.USPESNO_PROSLEDJENA_PORUKA: JOptionPane.showMessageDialog(null, "USPESNO PROSLEDJENA PORUKA");
            break;
            
            case Operacije.NOVA_PORUKA: 
                
                Poruka poruka = (Poruka) odgovor.getObjekatIzvrsenjaOperacije();
                tmp.dodajPoruku(poruka);                
                break;
        }
    }
    
    
    
    
    
    
    
}
