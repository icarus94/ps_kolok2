/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Slovo;
import forme.ServerskaForma;
import java.net.Socket;
import kom.KomunikacijaSaKlijentom;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Miroslav
 */
public class OBradaZahtevaKlijenta extends Thread{
    Socket s;
    String korisnik;
    ServerskaForma sf ;

    public OBradaZahtevaKlijenta(Socket s, String korisnik, ServerskaForma sf) {
        this.s = s;
        this.korisnik = korisnik;
        this.sf = sf;
    }
    
    @Override
    public void run() {
        while(!Kontroler.getInstance().isKraj()){
            KlijentskiZahtev kz = KomunikacijaSaKlijentom.getInstance().vratiZahtev(s);
            
            String slovo = kz.getSlovo();
            
            Slovo sl = Kontroler.getInstance().proveriDaLiSlovoPostoji(slovo);
            
            for (Slovo s : Kontroler.getInstance().getListaslova()) {
                System.out.println(s.getSlovo()+" br "+s.getPoena());
            }
            
            if(Kontroler.getInstance().getImePrvog().equals(korisnik)){
                Kontroler.getInstance().setBrojPoenaPrvog(Kontroler.getInstance().getBrojPoenaPrvog()+sl.getPoena());
            }
            if(Kontroler.getInstance().getImeDrugog().equals(korisnik)){
                Kontroler.getInstance().setBrojPoenaDrugog(Kontroler.getInstance().getBrojPoenaDrugog()+sl.getPoena());
            }
            sf.promeniRezultat();
            
            ServerskiOdgovor so = new ServerskiOdgovor();
            so.setBrPoenaDrugiIgrac(Kontroler.getInstance().getBrojPoenaDrugog());
            so.setPocelaIgra(true);
            so.setBrPoenaPrviIgrac(Kontroler.getInstance().getBrojPoenaPrvog());
            so.setDrugiIgrac(Kontroler.getInstance().getImeDrugog());
            so.setPrviIgrac(Kontroler.getInstance().getImePrvog());
            so.setSlovo(sl);
            
            if(Kontroler.getInstance().getListaslova().size() == 0){
                if(Kontroler.getInstance().getBrojPoenaPrvog()> Kontroler.getInstance().getBrojPoenaDrugog()){
                 so.setPoruka("Pobedio je prvi igrac: "+Kontroler.getInstance().getImePrvog());
                }else{
                 so.setPoruka("Pobedio je drugi igrac: "+Kontroler.getInstance().getImeDrugog()); 
                }
                so.setKrajIgre(true);
                Kontroler.getInstance().setKraj(true);
            }else{
                so.setKrajIgre(false);
            }
            
            KomunikacijaSaKlijentom.getInstance().posaljiOdgovor(so, Kontroler.getInstance().getS1());
            KomunikacijaSaKlijentom.getInstance().posaljiOdgovor(so, Kontroler.getInstance().getS2());
            
            
            
        }
    }
    
    
}
