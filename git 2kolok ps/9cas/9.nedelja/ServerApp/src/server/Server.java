/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Mesto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import request.RequestObject;
import response.ResponseObject;
import util.ActionCode;
import util.EnumResponseStatus;

/**
 *
 * @author student
 */
public class Server {

    public void pokreniServera() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server program je pokrenut!\nCekam klijenta.");
        Socket socket = serverSocket.accept();
        System.out.println("Klijent se povezao sa serverom");

        obradiKlijenta(socket);

    }

    private void obradiKlijenta(Socket socket) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Cekam zahtev klijenta");
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            Object object = inSocket.readObject();
            RequestObject requestObject = (RequestObject) object;
            
            ResponseObject responseObject = obradiZahtev(requestObject);
            ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
            outSocket.writeObject(responseObject);
            outSocket.flush();
        }   
    }

    private ResponseObject obradiZahtev(RequestObject requestObject) throws IOException {
        ResponseObject responseObject = new ResponseObject();

        int akcija = requestObject.getAction();
        switch (akcija) {
            case ActionCode.GET_ALL_PLACES:
                List<Mesto> mesta = kontroler.Kontroler.vratiMesta();
                responseObject.setResponse(mesta);
                responseObject.setResponseStatus(EnumResponseStatus.OK);
                return responseObject;
            default:
                return responseObject;
        }
    }
}
