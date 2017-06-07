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
public class Nit1 extends Thread {

    boolean radi = true;

    public void prekini() {
        radi = false;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        int i = 1;
        while (radi) {
            System.out.println("Nit1 se izvrsava:" + (i++));
            try {
                System.out.println("nit se uspavala");
                sleep(2000);
                System.out.println("nit se probudila");
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
