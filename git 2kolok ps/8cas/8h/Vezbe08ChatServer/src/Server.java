
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut!");
        Socket soketKlijent = ss.accept();
        System.out.println("Klijent se povezao!");
        System.out.println(soketKlijent.getPort());

        while (true) {
            BufferedReader inTastatura = new BufferedReader(new InputStreamReader(System.in));
            String poruka = inTastatura.readLine();
            PrintWriter out = new PrintWriter(soketKlijent.getOutputStream(), true);
            out.println(poruka);
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(soketKlijent.getInputStream()));
            poruka = in.readLine();
            System.out.println("KLIJENT> " + poruka);
            if("kraj".equals(poruka)){
                break;
            }
        }
    }
}
