/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class MojaDrugaNit implements Runnable{

    @Override
    public void run() {
        System.out.println("Nit "+Thread.currentThread().getName()+" pocinje sa izvrsavanjem!");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " "+ (i+1));
        }
        System.out.println("Nit "+Thread.currentThread().getName()+" zavrsava sa izvrsavanjem!");
    }
    
}
