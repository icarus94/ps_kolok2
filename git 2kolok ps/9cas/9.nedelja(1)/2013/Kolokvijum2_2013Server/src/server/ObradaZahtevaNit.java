/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.ServerskaForma;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import op.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class ObradaZahtevaNit extends Thread{
    Socket s;
    ServerskaForma sf;
    boolean kraj = false;

    public ObradaZahtevaNit(Socket s, ServerskaForma sf) {
        this.s = s;
        this.sf = sf;
    }

    @Override
    public void run() {
        while (!kraj) {            
            KlijentskiZahtev kz = primiZahtev();
            
            ServerskiOdgovor so = new ServerskiOdgovor();
            
            switch(kz.getOperacija()){
                case Operacije.POVEZI_SE:
                    String korisnik = kz.getKorisnickoIme();
                    if(!Kontroler.getInstanca().daLiJeUlogovan(korisnik)){
                        Kontroler.getInstanca().dodajUlogovanogKorisnika(korisnik);
                        if(Kontroler.getInstanca().daLiJeIspravnoIme(korisnik)){
                            so.setPoruka("Uspesno ste se prijavili na sistem");
                            so.setUspesno(true);
                        }else{
                            so.setPoruka("Korisnik nema pravo pristupa sistemu");
                            so.setUspesno(false);
                        }
                    }else{
                        so.setPoruka("Korisnik je vec pristupio sistemu");
                        so.setUspesno(false);
                    }
                    
                    posaljiOdgovorJednomKorisniku(so,s);
                    
                    break;
                case Operacije.IZBACI:
                    
                    int pozicija = kz.getPozicija();
                    String poruka = sf.odradiPosaoKojiTrebas(pozicija, kz.getKorisnickoIme());
                    so.setPoruka(poruka);
                    
                    for (Socket soket : Kontroler.getInstanca().getListaKorisnika()) {
                         posaljiOdgovorJednomKorisniku(so,soket);
                    }
                    
                    break;
            }
        }
    }

    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;
    }

    private void posaljiOdgovorJednomKorisniku(ServerskiOdgovor so,Socket soket) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
