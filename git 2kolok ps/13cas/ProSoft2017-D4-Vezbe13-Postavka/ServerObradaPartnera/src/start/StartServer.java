/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import nit.NitObradaKlijenta;

/**
 *
 * @author student
 */
public class StartServer {
    
    public static void main(String[] args) {
        StartServer start = new StartServer();
        start.startujServer();
    }
    
    
    
    public void startujServer(){
        try {
            ServerSocket serverSoket = new ServerSocket(9000);
            System.out.println("KREIRAN SERVERSKI SOKET!");
          
            while (true) {
                Socket vezaSaKlijentom = serverSoket.accept(); // blokira programsku nit
                System.out.println("Klijent se povezao.");
                NitObradaKlijenta nit = new NitObradaKlijenta(vezaSaKlijentom);
                nit.start();
                System.out.println("Napravljena je nit za klijenta.");
            }
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
