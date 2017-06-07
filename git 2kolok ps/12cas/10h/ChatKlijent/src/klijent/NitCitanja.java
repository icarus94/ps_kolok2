/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author student
 */
public class NitCitanja extends Thread {

    private Socket socket;
    private BufferedReader in;
    JTextArea jTextAreaPoruke;

    public NitCitanja(Socket socket, JTextArea jTextAreaPoruke) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.jTextAreaPoruke=jTextAreaPoruke;
    }

    @Override
    public void run() {
        try {
            while (true) {

                String poruka = in.readLine();
                //System.out.println(poruka);
                jTextAreaPoruke.append(poruka+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(NitCitanja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
