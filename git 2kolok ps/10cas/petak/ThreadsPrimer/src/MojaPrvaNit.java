/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class MojaPrvaNit extends Thread{

    public MojaPrvaNit(String ime) {
        this.setName(ime);
    }

    @Override
    public void run() {
        System.out.println("Nit "+this.getName()+" pocinje sa izvrsavanjem!");
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+ " "+ (i+1));
        }
        System.out.println("Nit "+this.getName()+" zavrsava sa izvrsavanjem!");
    }
    
    
    
}
