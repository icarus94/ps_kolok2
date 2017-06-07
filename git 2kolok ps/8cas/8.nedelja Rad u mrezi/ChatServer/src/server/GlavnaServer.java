/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author student
 */
public class GlavnaServer {
    
    
    public static void main(String[] args) throws IOException {
        
        
        ServerSocket serverSoket = new ServerSocket(9000);
        System.out.println("KREIRAN JE SERVERSKI SOKET!!!");
        Socket vezaSaKlijentom =  serverSoket.accept();
        System.out.println("KLIJENT SE POVEZAO SA SERVEROM!!!");
        
        BufferedReader inOdKlijenta = new BufferedReader(new InputStreamReader(vezaSaKlijentom.getInputStream()));
        
        BufferedReader inTastatura = new BufferedReader(new InputStreamReader(System.in));        
        PrintWriter outKaKlijentu = new PrintWriter(vezaSaKlijentom.getOutputStream(), true);
        
        String poruka="";
        while(!poruka.equalsIgnoreCase("KRAJ")){
            
            poruka = inOdKlijenta.readLine();
            System.out.println("PORUKA OD KLIJENTA:"+poruka);
            if (!poruka.equalsIgnoreCase("KRAJ")){
                System.out.print("Upisi poruku za klijenta:");
                poruka = inTastatura.readLine();
                outKaKlijentu.println(poruka);
            }
        }
        
    }
    
    
}
