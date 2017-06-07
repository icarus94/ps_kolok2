/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Kategorija;
import domen.Korisnik;
import forme.ServerskaForma;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
public class ObradaZahtevaNit extends Thread{
    Socket s;
    ServerskaForma sf;
    boolean kraj = false;
    String zadataRec = "";
    String zadataRecSaZvezdicama="";
    int brojPokusaja = 0;
    Korisnik k;
    Kategorija kat;

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
                case Operacije.LOGIN: //radim nesto
                    k = kz.getKorisnik();
                    kat = kz.getKat();
                    
                    boolean uspesno = Kontroler.getInstanca().ubaciKorisnika(k);
                    
                    so.setUspesno(uspesno);
                    
                    if(uspesno){
                        zadataRec = vratiZadatuRec(kat);
                        for (int i = 0; i < zadataRec.length(); i++) {
                            zadataRecSaZvezdicama+="*";
                        }
                        brojPokusaja = zadataRec.length()+ 8;
                        sf.setPodaci(zadataRec,zadataRecSaZvezdicama,brojPokusaja, k,kat);
                        so.setBrojPokusaja(brojPokusaja);
                        so.setZadataRec(zadataRecSaZvezdicama);
                        so.setPoruka("Uspesno ulogovan korisnik");
                    }else{
                        so.setPoruka("Korisnik vec postoji u sistemu");
                    }
                    
                    break;
                    
                case Operacije.POSALJI:
                    
                    brojPokusaja--;
                    
                    char slovo = kz.getSlovo();
                    String nalepi = "";
                    for (int i = 0; i < zadataRec.toUpperCase().length(); i++) {
                        
                        if (zadataRec.toUpperCase().charAt(i) == slovo) {
                            nalepi+=zadataRec.toUpperCase().charAt(i);
                        }else{
                            nalepi+=zadataRecSaZvezdicama.toUpperCase().charAt(i);
                        }
                    }
                    
                    zadataRecSaZvezdicama = nalepi;
                    
                    if(brojPokusaja<1){
                        so.setPoruka("IZgubili ste");
                        so.setKraj(true);
                        kraj = true;
                    }
                    if(!zadataRecSaZvezdicama.contains("*")){
                        so.setKraj(true);
                        so.setPoruka("Pobedili ste");
                        kraj = true;
                    }
                    
                    sf.setPodaci(zadataRec,zadataRecSaZvezdicama,brojPokusaja, k,kat);
                    so.setBrojPokusaja(brojPokusaja);
                    so.setZadataRec(zadataRecSaZvezdicama);
                    
                    break;
            }
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        ObjectInputStream ois = null;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ois = new ObjectInputStream(s.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
            //ois.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            //oos.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String vratiZadatuRec(Kategorija kat) {
        if(kat.getId()==1){
            return "Lisabon";
        }
        if(kat.getId()==2){
            return "Matematika";
        }
        if(kat.getId()==3){
            return "Obilic";
        }
        
        return "";
    }
    
    
}
