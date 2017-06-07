/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kom;

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

    private static KomunikacijaSaServerom instance;
    Socket soket;
    
    private KomunikacijaSaServerom() {
    }

    public static KomunikacijaSaServerom getInstance() {
        if(instance == null)
            instance = new KomunikacijaSaServerom();
        return instance;
    }
    
    public boolean poveziSe(String ipAdresa,int port){
        try {
            soket = new Socket(ipAdresa, port);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void posaljiZahtev(KlijentskiZahtev kz){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerskiOdgovor primiOdgovor(){
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
    
}
