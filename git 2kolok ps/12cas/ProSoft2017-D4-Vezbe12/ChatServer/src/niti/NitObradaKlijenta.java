/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Poruka;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelitabele.NoviDogadjaj;
import modelitabele.OsluskivacDogadjaja;
import operacije.Operacije;
import transfer.OdgovorServera;
import transfer.ZahtevKlijenta;

/**
 *
 * @author student
 */
public class NitObradaKlijenta extends Thread{

    Socket vezaSaKlijentom;
    List<NitObradaKlijenta> listaKlijenata;
    String nick;
    boolean prijavljen = false;
    
    ObjectOutputStream outKaKlijentu;
    ObjectInputStream inOdKlijenta;
    

    public NitObradaKlijenta(Socket vezaSaKlijentom, List<NitObradaKlijenta> listaKlijenata) throws IOException {
        this.vezaSaKlijentom = vezaSaKlijentom;
        this.listaKlijenata = listaKlijenata;
        inOdKlijenta = new ObjectInputStream(vezaSaKlijentom.getInputStream());
        outKaKlijentu = new ObjectOutputStream(vezaSaKlijentom.getOutputStream());
        
    }
    
    
    
    @Override
    public void run() {
        
        try {
            
            //***    PRIJAVA KORISNIKA   *******/
            ZahtevKlijenta zahtevZaPrijavu = primiZahtev();
            obradiZahtevIPoslajiOdgovor(zahtevZaPrijavu);
            
            //***    PRIJAVA KORISNIKA - KRAJ  *******/
            
            while(true){
                
                ZahtevKlijenta zahtev = primiZahtev();
                obradiZahtevIPoslajiOdgovor(zahtev);
                
                
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(NitObradaKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
   public ZahtevKlijenta primiZahtev() throws Exception{
       
       return (ZahtevKlijenta) inOdKlijenta.readObject();
   }
   
   public void posaljiOdgovor(OdgovorServera odgovor) throws IOException{
       
       outKaKlijentu.writeObject(odgovor);
   }

    private void obradiZahtevIPoslajiOdgovor(ZahtevKlijenta zahtev) {
        
        try {
            OdgovorServera odgovor = new OdgovorServera();
            
            switch (zahtev.getOperacija()){
                
                case Operacije.PRIJAVA:
                    odgovor.setOperacija(Operacije.USPESNA_PRIJAVA);
                    nick = (String) zahtev.getObjekatOperacije();
                    prijavljen = true;                    
                    posaljiOdgovor(odgovor);
                    /*     *********   Obaveastava se model tabele da se desio novi dogadjaj    ********    */
                    NoviDogadjaj dogadjajPrijava = new NoviDogadjaj(nick, NoviDogadjaj.KORISNIK_SE_PRIJAVIO);
                    obavestiOsluskivaceDaSeDesioDogadjaj(dogadjajPrijava);
                    /* * **********************    **********************************   */
                    break;
                    
                
                case Operacije.POSALJI_PORUKU:
                    Poruka poruka  = (Poruka) zahtev.getObjekatOperacije();
                    odgovor.setOperacija(Operacije.NOVA_PORUKA);
                    odgovor.setObjekatIzvrsenjaOperacije(poruka);
                    for (NitObradaKlijenta nitObradaKlijenta : listaKlijenata) {
                        
                        if (poruka.getZaKogaJePoruka().isEmpty() || poruka.getZaKogaJePoruka().equalsIgnoreCase(nitObradaKlijenta.nick)){
                            
                               nitObradaKlijenta.posaljiOdgovor(odgovor);
                            
                        }                                               
                    }
                    /*     *********   Obaveastava se model tabele da se desio novi dogadjaj    ********    */
                    NoviDogadjaj dogadjajSlanjePoruke = new NoviDogadjaj(nick, NoviDogadjaj.KORISNIK_POSLAO_PORUKU);
                    obavestiOsluskivaceDaSeDesioDogadjaj(dogadjajSlanjePoruke);
                    /* * **********************    **********************************   */
                    break;
                    
                    
                    
                    
                    
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(NitObradaKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

    
}

    
    /*  DEO ZA REGISTROVANJE OSLUSKIVACA NA POJAVU DOGADJAJA   */

    List<OsluskivacDogadjaja> listaRegistrovanihOsluskivaca = new ArrayList<>();
    
    public void registrujOsluskivacDogadjaja(OsluskivacDogadjaja od){
        listaRegistrovanihOsluskivaca.add(od);
    }
    
    public void obavestiOsluskivaceDaSeDesioDogadjaj(NoviDogadjaj noviDogadjaj){
        for (OsluskivacDogadjaja osluskivacDogadjaja : listaRegistrovanihOsluskivaca) {
            osluskivacDogadjaja.desioSeDogadjaj(noviDogadjaj);
        }
    }
    
    /*  ***********************                      *********************** */
}