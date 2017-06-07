/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Korisnik;
import java.util.ArrayList;

/**
 *
 * @author Miroslav
 */
public class Kontroler {

    private static Kontroler instanca;
    ArrayList<Korisnik> listaUlogovanihKorisnika;
    
    public Kontroler() {
        listaUlogovanihKorisnika = new ArrayList<>();
    }

    public static Kontroler getInstanca() {
        if(instanca == null){
            instanca = new Kontroler();
        }
        
        return instanca;
    }
    
    public boolean ubaciKorisnika(Korisnik k){
        if(listaUlogovanihKorisnika.contains(k)){
            return false;
        }
        
        listaUlogovanihKorisnika.add(k);
        return true;
    }
    
}
