/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelitabele.TableModelLogovaniKorisnici;
import niti.NitObradaKlijenta;
import transfer.OdgovorServera;
import transfer.ZahtevKlijenta;

/**
 *
 * @author student
 */
public class Start extends Thread{
    
    int port;
    List<NitObradaKlijenta> listaKlijenata;
    TableModelLogovaniKorisnici tmlk;
    

    public Start(int port, TableModelLogovaniKorisnici tmlk) {
        this.port = port;
        listaKlijenata = new ArrayList<>();
        this.tmlk = tmlk;
    }
    
    
    
    
    Socket vezaSaKlijentom;
    

    @Override
    public void run() {
        try {
            startujServer();
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public void startujServer() throws IOException, ClassNotFoundException{
        
        ServerSocket ss = new ServerSocket(port);
        System.out.println("KREIRAN JE SERVERSKI SOKET");
        
        while(true){
            vezaSaKlijentom = ss.accept(); // Blokira programsku nit dok god se ne poveze neki klijent
            System.out.println("USPOSTAVLJENA JE VEZA SA KLIJENTOM!");
        
            NitObradaKlijenta nitObrada = new NitObradaKlijenta(vezaSaKlijentom, listaKlijenata);
            listaKlijenata.add(nitObrada);
            nitObrada.registrujOsluskivacDogadjaja(tmlk);
            nitObrada.start();
            
        }
        
        
    }

    
    
    
}
