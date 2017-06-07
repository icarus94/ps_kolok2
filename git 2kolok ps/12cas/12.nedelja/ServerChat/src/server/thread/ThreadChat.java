/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.thread;

import com.sun.corba.se.pept.encoding.InputObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import request.RequestObjectLogin;
import request.RequestObjectMessage;

/**
 *
 * @author student
 */
public class ThreadChat extends Thread {

    List<ThreadChat> users;
    private Socket socket;
    ObjectInputStream in;
    private String user;

    public ThreadChat(Socket socket, List<ThreadChat> users) {
        this.socket = socket;
        this.users = users;
    }

    @Override
    public void run() {
        while (true) {
            try {
                in = new ObjectInputStream(socket.getInputStream());
                Object inObject = in.readObject();

                if (inObject instanceof RequestObjectLogin) {
                    RequestObjectLogin objectLogin = (RequestObjectLogin) inObject;
                    System.out.println("User: " + objectLogin.getUsername());
                    setUser(objectLogin.getUsername());
                }

                if (inObject instanceof RequestObjectMessage) {
                    RequestObjectMessage objectMessage = (RequestObjectMessage) inObject;
                    System.out.println("Message: " + objectMessage.getMessage());
                    sendMessage(objectMessage.getMessage());
                }
            } catch (IOException ex) {
                Logger.getLogger(ThreadChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    private void sendMessage(String message) {
        for (ThreadChat threadUser : users) {
            if (threadUser != this) {
                Socket socket = threadUser.getSocket();
                try {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    StringBuilder sbMessage = new StringBuilder("");
                    sbMessage.append("@").append(getUser()).append(":").append(message);
                    out.writeObject(sbMessage.toString());
                    out.flush();
                } catch (IOException ex) {
                    Logger.getLogger(ThreadChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
