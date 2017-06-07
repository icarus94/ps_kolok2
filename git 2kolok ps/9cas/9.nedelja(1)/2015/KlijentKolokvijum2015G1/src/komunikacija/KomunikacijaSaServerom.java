/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class KomunikacijaSaServerom {
    
    private static KomunikacijaSaServerom instanca;
    Socket soket;
    
    private KomunikacijaSaServerom (){
        try {
            soket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static KomunikacijaSaServerom getInstanca() {
        if(instanca == null)
            instanca = new KomunikacijaSaServerom();
        return instanca;
    }
    
    public void posaljiZahtev(KlijentskiZahtev kz){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(kz);
            //oos.close();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerskiOdgovor primiOdgovor(){
        ServerskiOdgovor so = new ServerskiOdgovor();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(soket.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
            //ois.close();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
    
}
