/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

/**
 *
 * @author student
 */
public class Glavna {
    
    
    public static void main(String[] args) throws UnknownHostException, MalformedURLException, IOException {
        
        InetAddress local  = InetAddress.getLocalHost();
        System.out.println("LOCALNA ADRESA:"+local);
        
        
        InetAddress fon = InetAddress.getByName("www.fon.bg.ac.rs");
        System.out.println("FON ADRESA:"+fon);
        
        
        InetAddress google[] = InetAddress.getAllByName("www.google.com");
        System.out.println("GOOGLE:");
        for (InetAddress inetAddress : google) {
            System.out.println(inetAddress);
        }
        
        
        URL url  = new URL("http://www.fon.bg.ac.rs");
        
        URLConnection urlKonekcija = url.openConnection();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(urlKonekcija.getInputStream()));
        String linija;
        while((linija=in.readLine())!=null){
            System.out.println(linija);            
        }
        
        
    }
    
    
}
