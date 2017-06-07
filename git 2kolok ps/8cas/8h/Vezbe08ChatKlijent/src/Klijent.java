
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
public class Klijent {

    public static void main(String[] args) throws IOException {
        Socket soketServer = new Socket("localhost", 9000);
        System.out.println("Klijent se povezao sa serverom!");
        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(soketServer.getInputStream()));
            String poruka = in.readLine();
            System.out.println("SERVER> " + poruka);
            if ("kraj".equals(poruka)) {
                break;
            }

            BufferedReader tastatura = new BufferedReader(new InputStreamReader(System.in));
            poruka = tastatura.readLine();
            PrintWriter out = new PrintWriter(soketServer.getOutputStream(), true);
            out.println(poruka);
            out.flush();
        }
    }
}
