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
import transfer.ZahtevKlijenta;

/**
 *
 * @author student
 */
public class Start {
    
    Socket vezaSaKlijentom;
    ObjectOutputStream outKaKlijentu;
    ObjectInputStream inOdKlijenta;
    
    public static void main(String[] args) {
        
        try {
            Start start = new Start();
            start.startujServer();
            
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }       
    
    public void startujServer() throws IOException, ClassNotFoundException{
        
        ServerSocket ss = new ServerSocket(9001);
        System.out.println("KREIRAN JE SERVERSKI SOKET");
        
        vezaSaKlijentom = ss.accept(); // Blokira programsku nit dok god se ne poveze neki klijent
        System.out.println("USPOSTAVLJENA JE VEZA SA KLIJENTOM!");
        
        inOdKlijenta = new ObjectInputStream(vezaSaKlijentom.getInputStream());
        outKaKlijentu = new ObjectOutputStream(vezaSaKlijentom.getOutputStream());
        osluskujZahteveKlijenta();
        
        
    }

    private void osluskujZahteveKlijenta() throws IOException, ClassNotFoundException {
        
        while(true){
        // BLOKIRA SE PROGRAMSKA NIT DOK GOD KLIJENT NE POSALJE ZAHTEV
            ZahtevKlijenta zahtev = (ZahtevKlijenta) inOdKlijenta.readObject();        
            System.out.println("STIGAO JE ZAHTEV!!!");
            obradiZahtevIPosaljiOdgovor(zahtev);        
        }
        
    }

    private void obradiZahtevIPosaljiOdgovor(ZahtevKlijenta zahtev) throws IOException {
        
        OdgovorServera odgovor = new OdgovorServera();
        
        switch(zahtev.getOperacija()){
            
            
            case ZahtevKlijenta.VRATI_SVE_PROIZVODE: 
            
        {
            try {
                List<Proizvod> listaProizvoda = KontrolerPL.vratiInstancu().vratiSveProizvode();
                odgovor.setObjekatIzvrsenjaOperacije(listaProizvoda);
            } catch (Exception ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                odgovor.setIzuzetak(ex);
            }
            break;
        }
        
        case ZahtevKlijenta.VRATI_SVE_PARTNERE: 
            
        {
            try {
                List<PoslovniPartner> listaPartnera = KontrolerPL.vratiInstancu().vratiSvePartnere();
                odgovor.setObjekatIzvrsenjaOperacije(listaPartnera);
            } catch (Exception ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                odgovor.setIzuzetak(ex);
            }
            break;
        }
                
            
            
            
        }
                
        outKaKlijentu.writeObject(odgovor);
        
        
        
    }
    
    
    
}
