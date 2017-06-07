/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Miroslav
 */
public class Kontroler {
    
    private static Kontroler instanca;
    LinkedList<Integer> lista;
    ArrayList<Socket> listaKlijenata;

    private Kontroler() {
        lista = new LinkedList<>();
        listaKlijenata = new ArrayList<>();
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }
    
    public boolean dodajUListu(int broj){
        int brojac = 0;
        
        for (Integer b : lista) {
            if(b == broj){
                brojac++;
            }
        }
        
        if(brojac > 1){
            return false;
        }
        
        lista.addFirst(broj);
        
        return true;
    }

    public LinkedList<Integer> getLista() {
        return lista;
    }

    public int izbrisiBroj() {
        return lista.removeFirst();
    }

    public void dodajSoket(Socket s) {
        listaKlijenata.add(s);
    }

    public ArrayList<Socket> getListaKlijenata() {
        return listaKlijenata;
    }
    
    
    
}
