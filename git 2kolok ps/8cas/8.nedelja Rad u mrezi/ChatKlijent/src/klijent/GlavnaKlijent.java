/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author student
 */
public class GlavnaKlijent {
    
    
    public static void main(String[] args) throws IOException {
        
        Socket vezaSaServerom  = new Socket("localhost", 9000);
        System.out.println("OSTVARENA JE VEZA SA SERVEROM!!!");
        
        
        BufferedReader inTastatura = new BufferedReader(new InputStreamReader(System.in));
        
        PrintWriter outKaServeru = new PrintWriter(vezaSaServerom.getOutputStream(), true);
        BufferedReader inOdServera = new BufferedReader(new InputStreamReader(vezaSaServerom.getInputStream()));
        
        String poruka="";
        while(!poruka.equalsIgnoreCase("KRAJ")){
                        
            
            System.out.print("UPISI PORUKU:");
            poruka = inTastatura.readLine();
            outKaServeru.println(poruka);
            
            if (!poruka.equalsIgnoreCase("KRAJ")){
            
            poruka = inOdServera.readLine();
            System.out.println("Poruka od servera:"+poruka);
            }
            
        }
        
        
        
        
        
    }
    
}
