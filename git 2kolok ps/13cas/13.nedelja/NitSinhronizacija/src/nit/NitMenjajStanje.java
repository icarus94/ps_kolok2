/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import domen.Stanje;
import java.util.Random;

/**
 *
 * @author student
 */
public class NitMenjajStanje extends Thread {

    private Stanje stanje;

    public NitMenjajStanje(Stanje stanje) {
        this.stanje = stanje;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 30; i++) {
            int broj = (int) (Math.random() * 10);
            stanje.povecaj(broj);
        }
        System.out.println("NitMenjajStanje je zavrsila sa radom.");
    }

}
