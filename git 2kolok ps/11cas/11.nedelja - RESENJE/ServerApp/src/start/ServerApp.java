/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import server.Server;

/**
 *
 * @author student
 */
public class ServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server= new Server();
        server.pokreniServera();
    }
    
}
