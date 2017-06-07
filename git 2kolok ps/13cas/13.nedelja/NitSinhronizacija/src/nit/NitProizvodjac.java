/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import domen.Stanje;

/**
 *
 * @author student
 */
public class NitProizvodjac extends Thread {

    private Stanje stanje;

    public NitProizvodjac(Stanje stanje) {
        this.stanje = stanje;
    }

    @Override
    public void run() {
        while (stanje.getKolicina()<100) {            
            int broj = (int) (Math.random()*10);
            stanje.povecaj(broj);
          
        }
        System.out.println("NitProizvodjac zavrsila sa radom.");
    }
    
    
}
