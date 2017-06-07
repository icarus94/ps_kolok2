/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import domen.PoslovniPartner;
import domen.Proizvod;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnaLogika.KontrolerPL;
import transfer.OdgovorServera;
import transfer.ZahtevKlienta;

/**
 *
 * @author student
 */
public class StartServer {
    
    ObjectInputStream inOdKlijenta;
    ObjectOutputStream outKaKlijentu;
    
    public static void main(String[] args) {
        
        StartServer start = new StartServer();
        start.startujServer();
        
        
    }
    
    
    
    public void startujServer(){
        try {
            ServerSocket serverSoket = new ServerSocket(9000);
            System.out.println("KREIRAN SERVERSKI SOKET!");
          
            Socket vezaSaKlijentom = serverSoket.accept(); // blokira programsku nit
            
            inOdKlijenta = new ObjectInputStream(vezaSaKlijentom.getInputStream());
            outKaKlijentu = new ObjectOutputStream(vezaSaKlijentom.getOutputStream());
            
            while(true){
                ZahtevKlienta zahtevKlijenta = (ZahtevKlienta) inOdKlijenta.readObject(); // blokira programsku nit dok god klijent ne posalje objekat
                obradiZahtevKlijenta(zahtevKlijenta);
            }
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    

    private void obradiZahtevKlijenta(ZahtevKlienta zahtevKlijenta) throws IOException {
        
        OdgovorServera odgovorServera = new OdgovorServera();
        
        switch(zahtevKlijenta.getOperacija()){
            
            case ZahtevKlienta.VRATI_SVE_PROIZVODE:  
                {
                    try {
                        List<Proizvod> listaProizvoda = KontrolerPL.vratiInstancu().vratiSveProizvode();
                        odgovorServera.setObjekatIzvrsenjaOperacije(listaProizvoda);
                    } catch (Exception ex) {
                        Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                        odgovorServera.setIzuzetak(ex);
                        odgovorServera.setSignal(0);
                    }
                    break;
                }
                
            case ZahtevKlienta.VRATI_SVE_PARTNERE:  
                {
                    try {
                        List<PoslovniPartner> listaPartnera = KontrolerPL.vratiInstancu().vratiSvePartnere();
                        odgovorServera.setObjekatIzvrsenjaOperacije(listaPartnera);
                    } catch (Exception ex) {
                        Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                        odgovorServera.setIzuzetak(ex);
                        odgovorServera.setSignal(0);
                    }
                    break;
                }    
            
            
            
            
        }
        
        
        outKaKlijentu.writeObject(odgovorServera);
        
        
    }
    
    
}
