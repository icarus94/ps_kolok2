
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Glavna {
    public static void main(String[] args) {
        Thread.currentThread().setName("Glavna nit");
        System.out.println("Izvrsava se nit (u main metodi):"+ Thread.currentThread());
        
        System.out.println("Kreiranje nove niti!");
        for (int i = 0; i < 10; i++) {
            //MojaPrvaNit nit1=new MojaPrvaNit("Nit"+(i+1));
            //System.out.println("Pokretanje nove niti!");
            //nit1.start();
            MojaDrugaNit target=new MojaDrugaNit();
            Thread nit=new Thread(target, "Nit"+(i+1));
            nit.start();
        }
        
        
        System.out.println("Nova nit je pokrenuta!");
        for (int i = 0; i < 10; i++) {
            System.out.println("main "+(i+1));
        }
        /*System.out.println("Uspavljivanje...");
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("Prekinuto spavanje!");
        }
        System.out.println("Budjenje...");*/
        System.out.println("Kraj main metode!");
    }
}
