
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Glavna {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException, IOException {
        InetAddress local=InetAddress.getLocalHost();
        System.out.println("Lokalna adresa: "+local);
        
        InetAddress fon=InetAddress.getByName("www.fon.bg.ac.rs");
        System.out.println("FON: "+fon);
        
        InetAddress[] google=InetAddress.getAllByName("www.google.com");
        System.out.println("Google: ");
        for (InetAddress inetAddress : google) {
            System.out.println(inetAddress);
        }
        
        URL url=new URL("http://www.fon.bg.ac.rs");
        URLConnection connection=url.openConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String input;
        while((input=br.readLine())!=null){
            System.out.println(input);
        }
        br.close();
    }
}
