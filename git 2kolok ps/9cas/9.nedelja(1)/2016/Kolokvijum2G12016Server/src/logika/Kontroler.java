/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Slovo;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Miroslav
 */
public class Kontroler {

    private static Kontroler instance;
    
    private String imePrvog;
    private String imeDrugog;
    private int brojPoenaPrvog;
    private int brojPoenaDrugog;
    private Socket s1;
    private Socket s2;
    private ArrayList<Slovo> listaslova;
    private ArrayList<Slovo> listaPogadjanihSlova;
    int ukupanBrojSekundi;
    
    boolean kraj = false;
    
    
    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    public String getImePrvog() {
        return imePrvog;
    }

    public void setImePrvog(String imePrvog) {
        this.imePrvog = imePrvog;
    }

    public String getImeDrugog() {
        return imeDrugog;
    }

    public void setImeDrugog(String imeDrugog) {
        this.imeDrugog = imeDrugog;
    }

    public int getBrojPoenaPrvog() {
        return brojPoenaPrvog;
    }

    public void setBrojPoenaPrvog(int brojPoenaPrvog) {
        this.brojPoenaPrvog = brojPoenaPrvog;
    }

    public int getBrojPoenaDrugog() {
        return brojPoenaDrugog;
    }

    public void setBrojPoenaDrugog(int brojPoenaDrugog) {
        this.brojPoenaDrugog = brojPoenaDrugog;
    }

    public Socket getS1() {
        return s1;
    }

    public void setS1(Socket s1) {
        this.s1 = s1;
    }

    public Socket getS2() {
        return s2;
    }

    public void setS2(Socket s2) {
        this.s2 = s2;
    }

    public ArrayList<Slovo> getListaslova() {
        return listaslova;
    }

    public void setListaslova(ArrayList<Slovo> listaslova) {
        this.listaslova = listaslova;
    }

    public ArrayList<Slovo> getListaPogadjanihSlova() {
        return listaPogadjanihSlova;
    }

    public void setListaPogadjanihSlova(ArrayList<Slovo> listaPogadjanihSlova) {
        this.listaPogadjanihSlova = listaPogadjanihSlova;
    }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public Slovo proveriDaLiSlovoPostoji(String slovo) {
        Slovo s1= new Slovo(slovo, 0);
        for (Slovo s : listaslova) {
            if(s.getSlovo().equals(slovo)){
                s1 = s;
            }
        }
        listaslova.remove(s1);
        return s1;
    }

    public void setUkupanBrojSekundi(int ukupanBrojSekundi) {
        this.ukupanBrojSekundi = ukupanBrojSekundi;
    }

    public int getUkupanBrojSekundi() {
        return ukupanBrojSekundi;
    }
    
    
    
}
