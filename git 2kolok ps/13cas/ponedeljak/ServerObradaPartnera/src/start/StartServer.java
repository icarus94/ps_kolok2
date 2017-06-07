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
import niti.NitObradaKlijenta;
import poslovnaLogika.KontrolerPL;
import transfer.OdgovorServera;
import transfer.ZahtevKlienta;

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
          
            while(true){
                Socket vezaSaKlijentom = serverSoket.accept(); // blokira programsku nit
                System.out.println("POVEZAO SE NOVI KLIJENT");
                NitObradaKlijenta nitObrada = new NitObradaKlijenta(vezaSaKlijentom);
                nitObrada.start();
                System.out.println("KREIRANA JE PROGRAMSKA NIT OBRADA.");                
                
            }
           
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }
    

    
}
