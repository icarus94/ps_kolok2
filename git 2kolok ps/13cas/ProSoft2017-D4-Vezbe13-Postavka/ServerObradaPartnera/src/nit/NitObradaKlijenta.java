/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

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
import start.StartServer;
import transfer.OdgovorServera;
import transfer.ZahtevKlienta;

/**
 *
 * @author student
 */
public class NitObradaKlijenta extends Thread {

    private ObjectInputStream inOdKlijenta;
    private ObjectOutputStream outKaKlijentu;
    private Socket vezaSaKlijentom;
    private boolean izvrsavaSe;

    public NitObradaKlijenta(Socket vezaSaKlijentom) throws IOException {
        this.vezaSaKlijentom = vezaSaKlijentom;
        this.inOdKlijenta = new ObjectInputStream(vezaSaKlijentom.getInputStream());
        this.outKaKlijentu = new ObjectOutputStream(vezaSaKlijentom.getOutputStream());
        this.izvrsavaSe = true;
    }

    @Override
    public void run() {
        try {
            while (izvrsavaSe) {
                ZahtevKlienta zahtevKlijenta = (ZahtevKlienta) inOdKlijenta.readObject(); // blokira programsku nit dok god klijent ne posalje objekat
                obradiZahtevKlijenta(zahtevKlijenta);
            }
            System.out.println("Kraj rada niti.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void obradiZahtevKlijenta(ZahtevKlienta zahtevKlijenta) throws IOException {
        OdgovorServera odgovorServera = new OdgovorServera();
        System.out.println("Operacija: " + zahtevKlijenta.getOperacija());
        switch (zahtevKlijenta.getOperacija()) {
            case ZahtevKlienta.VRATI_SVE_PROIZVODE: {
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

            case ZahtevKlienta.VRATI_SVE_PARTNERE: {
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
            
            case ZahtevKlienta.KRAJ_RADA:
                izvrsavaSe = false;
                break;

        }
        outKaKlijentu.writeObject(odgovorServera);

    }

}
