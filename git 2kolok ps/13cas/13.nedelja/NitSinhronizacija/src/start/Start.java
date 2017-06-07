/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import domen.Stanje;
import nit.NitMenjajStanje;
import nit.NitPotrosac;
import nit.NitProizvodjac;

/**
 *
 * @author student
 */
public class Start {

    public static void main(String[] args) throws InterruptedException {
        Stanje stanje = new Stanje(30);
//        Thread nitMenjajStanje1 = new NitMenjajStanje(stanje);
//        Thread nitMenjajStanje2 = new NitMenjajStanje(stanje);
//        nitMenjajStanje1.start();
//        nitMenjajStanje2.start();
//        nitMenjajStanje1.join();
//        nitMenjajStanje2.join();
        Thread proizvodjac = new NitProizvodjac(stanje);
        Thread potrosac = new NitPotrosac(stanje);
        proizvodjac.start();
        potrosac.start();
        proizvodjac.join();
        potrosac.join();
        System.out.println("Tekuce stanje:" + stanje.getKolicina());
        System.out.println("Kraj glavnog programa.");
    }
}
