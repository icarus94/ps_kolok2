/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.PoslovniPartner;
import domen.Proizvod;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnaLogika.KontrolerPL;
import start.Start;
import transfer.OdgovorServera;
import transfer.ZahtevKlijenta;

/**
 *
 * @author student
 */
public class NitObrada extends Thread { 
    
    Socket vezaSaKlijentom;
    ObjectOutputStream outKaKlijentu;
    ObjectInputStream inOdKlijenta;

    public NitObrada(Socket vezaSaKlijentom) throws IOException {
        this.vezaSaKlijentom = vezaSaKlijentom;
        inOdKlijenta = new ObjectInputStream(vezaSaKlijentom.getInputStream());
        outKaKlijentu = new ObjectOutputStream(vezaSaKlijentom.getOutputStream());
    }

    @Override
    public void run() {
        
        try {
            osluskujZahteveKlijenta();
        } catch (IOException ex) {
            Logger.getLogger(NitObrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NitObrada.class.getName()).log(Level.SEVERE, null, ex);
        }
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
