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
import transfer.OdgovorServera;
import transfer.ZahtevKlijenta;

/**
 *
 * @author student
 */
public class Komunikacija {
    
    
    Socket vezaSaServerom;
    ObjectOutputStream outKaServeru;
    ObjectInputStream inOdServera;
    
    
    private static Komunikacija instanca;

    private Komunikacija() throws IOException {
        vezaSaServerom = new Socket("localhost", 9001);
        
        outKaServeru = new ObjectOutputStream(vezaSaServerom.getOutputStream());
        inOdServera = new ObjectInputStream(vezaSaServerom.getInputStream());
        
    }
    
    public static Komunikacija vratiInstancu() throws IOException{
        if (instanca==null){
            instanca = new Komunikacija();
        }
        
        return instanca;
    }
    
    public OdgovorServera procitajOdgovor() throws IOException, ClassNotFoundException{
        return (OdgovorServera) inOdServera.readObject();
    }
    
    public void posaljiZahtev(ZahtevKlijenta zahtev) throws IOException {
        outKaServeru.writeObject(zahtev);
    }
    
    
}
