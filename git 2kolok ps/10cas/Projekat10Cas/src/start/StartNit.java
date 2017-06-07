/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import nit.Nit1;
import nit.Nit2;
import nit.Nit3;
import nit.Nit4;

/**
 *
 * @author student
 */
public class StartNit {
    public static void main(String[] args) throws InterruptedException {
        Thread glavnaNit= Thread.currentThread();
        System.out.println(glavnaNit);
               
        
        //nit.Nit1 n= new Nit1();
        //nit.Nit2 n= new Nit2();
        
        //nit.Nit3 n= new Nit3();
        nit.Nit4 n= new Nit4();
        n.start();
        
        glavnaNit.sleep(1000);
        n.prekini();
        System.out.println("Kraj programa");
    }
}
