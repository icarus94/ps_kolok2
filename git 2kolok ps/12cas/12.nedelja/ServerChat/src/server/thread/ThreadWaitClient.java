/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class ThreadWaitClient extends Thread {

    List<ThreadChat> users;

    public ThreadWaitClient() {
        users = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Cekam klijente...");
            while (true) {
                Socket socket = ss.accept();
                System.out.println("Klijent se povezao.");
                ThreadChat threadChat = new ThreadChat(socket, users);
                users.add(threadChat);
                threadChat.start();

            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadWaitClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
