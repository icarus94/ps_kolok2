/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.util.logging.Level;
import java.util.logging.Logger;
import magacin.Stanje;
import niti.NitPotrosac;
import niti.NitProizvodjac;

/**
 *
 * @author student
 */
public class Glavna {
    
    
    public static void main(String[] args) {
        
        try {
            Stanje stanje = new Stanje(30);
            
            NitProizvodjac nitProizvodjac = new NitProizvodjac(stanje);
            NitPotrosac nitPotrosac = new NitPotrosac(stanje);
            
            nitProizvodjac.start();
            nitPotrosac.start();
            
            
            
            nitProizvodjac.join();
            nitPotrosac.join();
            
            System.out.println("Konacno stanje magacina je "+stanje.getStanje());
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Glavna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
