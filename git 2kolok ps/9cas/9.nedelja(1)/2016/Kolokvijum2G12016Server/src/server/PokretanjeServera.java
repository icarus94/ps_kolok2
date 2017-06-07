package server;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import kom.KomunikacijaSaKlijentom;
import logika.Kontroler;
import niti.NitOdbrojavanje;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miroslav
 */
public class PokretanjeServera extends Thread{
    ServerskaForma sf;

    public PokretanjeServera(ServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Pokrenuo se server");
            Socket s1 = ss.accept();
            KlijentskiZahtev kz = KomunikacijaSaKlijentom.getInstance().vratiZahtev(s1);
            String korisnik1 = kz.getUsername();
            
            Kontroler.getInstance().setBrojPoenaPrvog(0);
            Kontroler.getInstance().setS1(s1);
            Kontroler.getInstance().setImePrvog(korisnik1);
            
            
            ServerskiOdgovor so = new ServerskiOdgovor();
            so.setPocelaIgra(false);
            so.setPoruka("Igra jos nije pocela, morate sacekati drugog korisnika");
            KomunikacijaSaKlijentom.getInstance().posaljiOdgovor(so, s1);
            Socket s2 = ss.accept();
            
            KlijentskiZahtev kz1 = KomunikacijaSaKlijentom.getInstance().vratiZahtev(s2);
            String korisnik2 = kz1.getUsername();
            
            Kontroler.getInstance().setBrojPoenaDrugog(0);
            Kontroler.getInstance().setS2(s2);
            Kontroler.getInstance().setImeDrugog(korisnik2);
            
            so.setPocelaIgra(true);
            so.setBrPoenaDrugiIgrac(0);
            so.setBrPoenaPrviIgrac(0);
            so.setDrugiIgrac(korisnik2);
            so.setPrviIgrac(korisnik1);
            so.setKrajIgre(false);
            so.setPobednik(false);
            so.setUkupnoSekundi(Kontroler.getInstance().getUkupanBrojSekundi());
            
            KomunikacijaSaKlijentom.getInstance().posaljiOdgovor(so, s1);
            KomunikacijaSaKlijentom.getInstance().posaljiOdgovor(so, s2);
            
            NitOdbrojavanje no = new NitOdbrojavanje(sf,Kontroler.getInstance().getUkupanBrojSekundi());
            no.start();
            
            OBradaZahtevaKlijenta okz1 = new OBradaZahtevaKlijenta(s1, korisnik1, sf);
            okz1.start();
            OBradaZahtevaKlijenta okz2 = new OBradaZahtevaKlijenta(s2, korisnik2, sf);
            okz2.start();
            
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
