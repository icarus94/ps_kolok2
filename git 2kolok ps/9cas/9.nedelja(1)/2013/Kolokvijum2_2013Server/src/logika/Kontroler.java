/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Miroslav
 */
public class Kontroler {

    private static Kontroler instanca;
    ArrayList<String> listaMogucih = new ArrayList<>();
    String[] nizMogucih = {"admin1","admin2","user1","user2"};
    ArrayList<String> ulogovani = new ArrayList<>();
    ArrayList<Socket> listaKorisnika = new ArrayList<>();
    
    private Kontroler() {
        for (int i = 0; i < nizMogucih.length; i++) {
           listaMogucih.add(nizMogucih[i]);
        }
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }
    
    public void dodajKorisnika(Socket s){
        listaKorisnika.add(s);
    }

    public ArrayList<Socket> getListaKorisnika() {
        return listaKorisnika;
    }
    public void dodajUlogovanogKorisnika(String korisnickoIme){
        ulogovani.add(korisnickoIme);
    }
    
    public boolean daLiJeUlogovan(String korisnickoIme){
        return ulogovani.contains(korisnickoIme);
    }

    public ArrayList<String> getListaMogucih() {
        return listaMogucih;
    }

    public ArrayList<String> getUlogovani() {
        return ulogovani;
    }
    
    public boolean daLiJeIspravnoIme(String korisnickoIme){
        return listaMogucih.contains(korisnickoIme);
    }
}
