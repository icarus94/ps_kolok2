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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class ObradaZahteva extends Thread{
    Socket s;
    boolean kraj = false;
    ServerskaForma sf;

    public ObradaZahteva(Socket s, ServerskaForma sf) {
        this.s = s;
        this.sf = sf;
    }
    
    

    @Override
    public void run() {
        while (!kraj) {            
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            
            switch(kz.getOperacija()){
                case Operacije.OBRISI:
                    
                    int izbrisaniBroj = Kontroler.getInstanca().izbrisiBroj();
                    so.setIzbrisaniBroj(izbrisaniBroj);
                    int ukupnoIzbrisanih = 4 - Kontroler.getInstanca().getLista().size();
                    so.setUkupno(ukupnoIzbrisanih);
                    so.setKraj(false);
                    if(Kontroler.getInstanca().getLista().size()==0){
                        so.setPoruka("KRAJ JE IGRE");
                        so.setKraj(true);
                        sf.napisiDasuIzbrisani();
                        ArrayList<Socket> listaKlijenta = Kontroler.getInstanca().getListaKlijenata();
                        
                        for (Socket socket : listaKlijenta) {
                            posaljiOdgovor(so,socket);
                        }
                    }else{
                        posaljiOdgovor(so,s);
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
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so,Socket soket) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
