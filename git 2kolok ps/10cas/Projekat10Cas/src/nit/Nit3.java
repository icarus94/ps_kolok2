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
public class Nit3 extends Thread {

    public void prekini() {
        interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        int i = 1;
        try {
            while (!isInterrupted()) {
                System.out.println("Nit1 se izvrsava:" + (i++));

                System.out.println("nit se uspavala");
                sleep(10000);//generise izuzetak ako je neko pozvao interrupt metodu, a nit se nalazi u stanju uspavanosti
                System.out.println("nit se probudila");

            }
        } catch (Exception e) {
            System.out.println("Kraj izvrsenja niti3");
        }

    }

}
