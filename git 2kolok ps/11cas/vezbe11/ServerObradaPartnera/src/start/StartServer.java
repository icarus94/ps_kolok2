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
import niti.NitKlijent;
import poslovnaLogika.KontrolerPL;
import transfer.OdgovorServera;
import transfer.ZahtevKlienta;

/**
 *
 * @author student
 */
public class StartServer {

    ObjectInputStream inOdKlijenta;
    ObjectOutputStream outKaKlijentu;

    public static void main(String[] args) {

        StartServer start = new StartServer();
        start.startujServer();

    }

    public void startujServer() {
        try {
            ServerSocket serverSoket = new ServerSocket(9000);
            System.out.println("KREIRAN SERVERSKI SOKET!");
            for (int i = 0; i < 10; i++) {
                Socket vezaSaKlijentom = serverSoket.accept(); // blokira programsku nit
                NitKlijent nitObradaKlijenta=new NitKlijent(vezaSaKlijentom);
                nitObradaKlijenta.start();

            }
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    

}
