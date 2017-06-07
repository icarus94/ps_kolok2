/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import constants.Constants;
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
public class ServerProgram {

    public void pokreniServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server je pokrenut. Ocekujem klijenta!");
        Socket socket = serverSocket.accept();
        System.out.println("Klijent se povezao sa serverom");
        pokreniChat(socket);
        System.out.println("Server: zavrsio sa radom");

    }

    private void pokreniChat(Socket socket) throws IOException {
        boolean signal = true;
        while (signal) {
            BufferedReader inSocket
                    = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String porukaKlijenta = inSocket.readLine();

            System.out.println("<Klijent>: " + porukaKlijenta);
            if (porukaKlijenta.equalsIgnoreCase(Constants.END_CHAT)) {
                signal = false;
            } else {
                //pripremi poruku za klijenta
                System.out.println("Server: ");
                BufferedReader inTastatura = new BufferedReader(new InputStreamReader(System.in));
                String porukaZaKlijenta = inTastatura.readLine();
                //posalji klijentu poruku
                PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
                outSocket.println(porukaZaKlijenta);
            }

        }

    }

}
