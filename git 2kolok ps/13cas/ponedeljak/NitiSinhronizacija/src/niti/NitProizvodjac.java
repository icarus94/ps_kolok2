/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.util.logging.Level;
import java.util.logging.Logger;
import magacin.Stanje;

/**
 *
 * @author student
 */
public class NitProizvodjac extends Thread{
    
    Stanje stanje;

    public NitProizvodjac(Stanje stanje) {
        this.stanje = stanje;
    }

    
    @Override
    public void run() {
        
        
        while(stanje.getStanje()<50){
            
            
                int kol = (int) Math.round(Math.random()*10);                
                stanje.povecaj(kol);
                //System.out.println("NIT PROIZVODJAC POVECALA STANJE ZA "+kol);
           
        }
        
    }
    
    
    
    
    
}
