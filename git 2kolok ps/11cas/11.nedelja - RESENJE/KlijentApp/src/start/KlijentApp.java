/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import klijent.Klijent;

/**
 *
 * @author student
 */
public class KlijentApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Klijent klijent= new Klijent();
        klijent.poveziSeSaServerom();
    }
    
}
