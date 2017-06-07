/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import constants.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author student
 */
public class KlijentProgram {

    public void pokreniKlijenta() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        System.out.println("Klijent se povezao sa serverom");
        pokreniChat(socket);
        System.out.println("Klijent: zavrsio sa radom");
    }

    private void pokreniChat(Socket socket) throws IOException {
        boolean signal = true;
        while (signal) {
            System.out.println("Klijent: ");
            BufferedReader inTastatura
                    = new BufferedReader(new InputStreamReader(System.in));
            String klijentPoruka = inTastatura.readLine();

            PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
            outSocket.println(klijentPoruka);
            if (klijentPoruka.equalsIgnoreCase(Constants.END_CHAT)) {
                signal = false;
            } else {
                //procitaj poruku od servera
                BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String porukaOdServera = inSocket.readLine();
                //odstampaj poruku od servera
                System.out.println("<Server>: " + porukaOdServera);
            }

        }

    }
}
