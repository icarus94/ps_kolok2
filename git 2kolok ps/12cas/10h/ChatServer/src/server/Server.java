/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import niti.KlijentNit;

/**
 *
 * @author student
 */
public class Server {
    private List<KlijentNit> klijenti = new ArrayList<>();
    
    public void startServer() throws IOException{
        ServerSocket serverSocket = new ServerSocket(9000);
        
        while(true){
            Socket socket = serverSocket.accept();
            KlijentNit nit = new KlijentNit(socket,this);
            klijenti.add(nit);
            nit.start();
        }
    }
    
    public void posaljiSvimaPoruku(String poruka){
        for (KlijentNit klijentNit : klijenti) {
            klijentNit.posaljiPoruku(poruka);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.startServer();
    }
}
