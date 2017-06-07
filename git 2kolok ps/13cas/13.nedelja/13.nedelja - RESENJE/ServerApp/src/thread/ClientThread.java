/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import businesslogic.systemoperation.GetAllPlacesSO;
import database.DBBroker;
import domen.Mesto;
import domen.PoslovniPartner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import request.RequestObject;
import response.ResponseObject;
import server.Server;
import util.ActionCode;
import util.EnumResponseStatus;

/**
 *
 * @author student
 */
public class ClientThread implements Runnable {

    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            obradiKlijenta(socket);
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
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

                try {
                    List<Mesto> mesta = kontroler.Kontroler.vratiMesta();
                    responseObject.setResponse(mesta);
                    responseObject.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception ex) {
                    responseObject.setResponseStatus(EnumResponseStatus.ERROR);
                    responseObject.setMessage(ex.getMessage());
                }

                return responseObject;
            case ActionCode.SAVE_ALL_BUSINESS_PARTNERS:
                List<PoslovniPartner> businessPartners = (List<PoslovniPartner>) requestObject.getRequest();

                try {
                    kontroler.Kontroler.sacuvajPartnere(businessPartners);
                    responseObject.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception ex) {
                    responseObject.setMessage(ex.getMessage());
                    responseObject.setResponseStatus(EnumResponseStatus.ERROR);
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                return responseObject;
            default:
                return responseObject;
        }
    }
}
