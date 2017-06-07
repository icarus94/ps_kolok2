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
import niti.NitObrada;
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

    public void startujServer() throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(9001);
        System.out.println("KREIRAN JE SERVERSKI SOKET");

        while (true) {
            vezaSaKlijentom = ss.accept(); // Blokira programsku nit dok god se ne poveze neki klijent
            System.out.println("USPOSTAVLJENA JE VEZA SA KLIJENTOM!");

            NitObrada nit = new NitObrada(vezaSaKlijentom);
            nit.start();

        }
    }

}
