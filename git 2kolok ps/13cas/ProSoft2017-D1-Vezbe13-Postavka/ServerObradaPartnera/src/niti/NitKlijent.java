/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Mesto;
import domen.PoslovniPartner;
import domen.Proizvod;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import poslovnaLogika.KontrolerPL;
import transfer.OdgovorServera;
import transfer.ZahtevKlienta;

/**
 *
 * @author student
 */
public class NitKlijent extends Thread {

    private Socket vezaSaKlijentom;
    private ObjectInputStream inOdKlijenta;
    private ObjectOutputStream outKaKlijentu;

    public NitKlijent(Socket socket) {
        this.vezaSaKlijentom = socket;
    }

    @Override
    public void run() {
        try{
            inOdKlijenta = new ObjectInputStream(vezaSaKlijentom.getInputStream());
            outKaKlijentu = new ObjectOutputStream(vezaSaKlijentom.getOutputStream());

            while (true) {
                ZahtevKlienta zahtevKlijenta = (ZahtevKlienta) inOdKlijenta.readObject(); // blokira programsku nit dok god klijent ne posalje objekat
                obradiZahtevKlijenta(zahtevKlijenta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void obradiZahtevKlijenta(ZahtevKlienta zahtevKlijenta) throws IOException {

        OdgovorServera odgovorServera = new OdgovorServera();

        switch (zahtevKlijenta.getOperacija()) {

            case ZahtevKlienta.VRATI_SVE_PROIZVODE: {
                try {
                    List<Proizvod> listaProizvoda = KontrolerPL.vratiInstancu().vratiSveProizvode();
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaProizvoda);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
            }

            case ZahtevKlienta.VRATI_SVE_POSLOVNE_PARTNERE: {
                try {
                    List<PoslovniPartner> listaPartnera = KontrolerPL.vratiInstancu().vratiSvePartnere();
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaPartnera);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
            }
            
            case ZahtevKlienta.VRATI_SVA_MESTA: {
                try {
                    List<Mesto> mesta = KontrolerPL.vratiInstancu().vratiSvaMesta();
                    odgovorServera.setObjekatIzvrsenjaOperacije(mesta);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
            }
            
            case ZahtevKlienta.SACUVAJ_PARTNERA: {
                try {
                    PoslovniPartner partner=(PoslovniPartner)zahtevKlijenta.getObjekatOperacije();
                    KontrolerPL.vratiInstancu().sacuvajPartnera(partner);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
            }
            
            case ZahtevKlienta.SACUVAJ_LISTU_POSLOVNIH_PARTNERA: {
                try {
                    List<PoslovniPartner> partneri=(List)zahtevKlijenta.getObjekatOperacije();
                    KontrolerPL.vratiInstancu().sacuvajListuPartnera(partneri);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
            }

        }

        outKaKlijentu.writeObject(odgovorServera);

    }

}
