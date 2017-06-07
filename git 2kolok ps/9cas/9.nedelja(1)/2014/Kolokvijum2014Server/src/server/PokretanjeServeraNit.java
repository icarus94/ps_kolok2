/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;

/**
 *
 * @author Miroslav
 */
public class PokretanjeServeraNit extends Thread{
    ServerskaForma sf;

    public PokretanjeServeraNit(ServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            sf.pokrenutServer();
            
            while (true) {                
                Socket s = ss.accept();
                System.out.println("Klijent se povezao");
                Kontroler.getInstanca().dodajSoket(s);
                ObradaZahteva oz = new ObradaZahteva(s,sf);
                oz.start();
            }
            
        } catch (IOException ex) {
            sf.nijeDobroServer();
        }
    }
    
    
}
