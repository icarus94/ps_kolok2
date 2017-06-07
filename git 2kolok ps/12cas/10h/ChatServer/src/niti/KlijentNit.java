/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

/**
 *
 * @author student
 */
public class KlijentNit extends Thread{
    private Socket socket;
    private Server server;
    private BufferedReader in;
    private PrintWriter out;
    private String ime;
    
    public KlijentNit(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new BufferedReader
        (new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter
        (socket.getOutputStream(),true);
    }
    
    
    @Override
    public void run() {
        try {
            ime = in.readLine();
            
            while (true) {                
                String poruka = in.readLine();
                poruka = ime +" : "+ poruka;
                server.posaljiSvimaPoruku(poruka);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void posaljiPoruku(String poruka){
        out.println(poruka);
    }
    
}
