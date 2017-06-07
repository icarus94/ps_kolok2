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
            sf.pokrenutJE();
            while (true) {                
                Socket s  = ss.accept();
                System.out.println("Klijent se povezao");
                ObradaZahtevaNit o = new ObradaZahtevaNit(s, sf);
                o.start();
            }
            
        } catch (IOException ex) {
            sf.nijePokrenut();
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
