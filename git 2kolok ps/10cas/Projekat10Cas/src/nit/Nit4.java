/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Nit4 extends Thread {

    public void prekini() {
        interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        int i = 1;
        System.out.println("0.Stanje niti:" + isInterrupted());
        while (!isInterrupted()) {
            System.out.println("Nit1 se izvrsava:" + (i++));

            try {
                sleep(10000);//generise izuzetak ako je neko pozvao interrupt metodu, a nit se nalazi u stanju uspavanosti
            } catch (InterruptedException ex) {
                System.out.println("1.Stanje niti:" + isInterrupted());
                interrupt();
                System.out.println("2.Stanje niti:" + isInterrupted());
                System.out.println("3.Stanje niti:" + interrupted());
                System.out.println("4.Stanje niti:" + isInterrupted());
                System.out.println("5.Stanje niti:" + interrupted());
                System.out.println("6.Stanje niti:" + isInterrupted());
                interrupt();
            }
            System.out.println("nit se probudila");

        }

        System.out.println("Kraj izvrsenja niti4");

    }

}
