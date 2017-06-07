/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author student
 */
public class ThreadReadMessage extends Thread {

    Socket socket;
    JTextArea jTextArea;
    ObjectInputStream in;

    public ThreadReadMessage(Socket socket, JTextArea jTextArea) {
        this.socket = socket;
        this.jTextArea = jTextArea;
    }

    @Override
    public void run() {
        while (true) {
            try {
                in = new ObjectInputStream(socket.getInputStream());
                String message = (String) in.readObject();
                jTextArea.append("\n");
                jTextArea.append(message);
            } catch (IOException ex) {
                Logger.getLogger(ThreadReadMessage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadReadMessage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
