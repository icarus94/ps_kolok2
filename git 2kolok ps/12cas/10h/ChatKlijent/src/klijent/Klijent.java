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
import view.JFrameChat;

/**
 *
 * @author student
 */
public class Klijent {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
        
        JFrameChat forma=new JFrameChat(socket);
        forma.setVisible(true);
        //NitCitanja nit = new NitCitanja(socket);
        //nit.start();
        
        //System.out.println("Unesite ime: ");
        //BufferedReader in = 
        //        new BufferedReader(new InputStreamReader(System.in));
        //String ime = in.readLine();
        //PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        //out.println(ime);
        
//        while(true){
//            
//            String poruka = in.readLine();
//            out.println(poruka);
//            
//        }
    }
}
