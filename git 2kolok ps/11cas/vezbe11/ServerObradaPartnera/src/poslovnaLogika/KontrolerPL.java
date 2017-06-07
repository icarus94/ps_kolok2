/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;

import dbbr.DBBroker;
import domen.Mesto;
import domen.PoslovniPartner;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poslovnaLogika.so.SOSacuvajListuPoslovnihPartnera;
import poslovnaLogika.so.SOSacuvajPartnera;
import poslovnaLogika.so.SOVratiSvaMesta;
import poslovnaLogika.so.SOVratiSvePoslovnePartnere;
import poslovnaLogika.so.SOVratiSveProizvode;

/**
 *
 * @author student
 */
public class KontrolerPL {

    //List<Mesto> listaMesta;
    //List<PoslovniPartner> listaPartnera;

    DBBroker dbbr;

    private static KontrolerPL instanca;

    public static KontrolerPL vratiInstancu() {

        if (instanca == null) {
            instanca = new KontrolerPL();
        }

        return instanca;
    }

    private KontrolerPL() {
       // listaMesta = new ArrayList<>();
       // listaPartnera = new ArrayList<>();
       // inicijalizujMesta();
        dbbr = new DBBroker();

    }

    private void inicijalizujMesta() {
        /*
        listaMesta.add(new Mesto(11000, "Beograd"));
        listaMesta.add(new Mesto(11070, "Novi Beograd"));
        listaMesta.add(new Mesto(11010, "Vozdovac"));
        listaMesta.add(new Mesto(35230, "Cuprija"));
        listaMesta.add(new Mesto(11250, "Zeleznik"));
                */
    }

    public List<Mesto> vratiSvaMesta() throws Exception {
        /*        
        //bez klase za sistemsku operaciju:
        List<Mesto> mesta=null;
        try{
            dbbr.uspostaviKonekciju();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        try{
            mesta=dbbr.vratiSvaMesta();
            dbbr.potvrdiTransakciju();
        }catch(Exception e){
            e.printStackTrace();
            dbbr.ponistiTransakciju();
            throw e;
        }finally{
            dbbr.raskiniKonekciju();
        }
        return mesta;
        */
        
        //sa klasom za sistemsku operaciju
         SOVratiSvaMesta so=new SOVratiSvaMesta();
         so.opsteIzvrsenje();
         return so.getMesta();
        
    }
    
     public List<PoslovniPartner> vratiSvePartnere() throws Exception {
        
        /* 
        //bez klase za sistemsku operaciju:
        List<PoslovniPartner> partneri=null;
        try{
            dbbr.uspostaviKonekciju();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        try{
            partneri=dbbr.vratiSvePartnere();
            dbbr.potvrdiTransakciju();
        }catch(Exception e){
            e.printStackTrace();
            dbbr.ponistiTransakciju();
            throw e;
        }finally{
            dbbr.raskiniKonekciju();
        }
        return partneri;
         */
         
         //sa klasom za sistemsku operaciju
         SOVratiSvePoslovnePartnere so=new SOVratiSvePoslovnePartnere();
         so.opsteIzvrsenje();
         return so.getPoslovniPartneri();
    }
     
    public List<Proizvod> vratiSveProizvode() throws Exception {
        SOVratiSveProizvode so=new SOVratiSveProizvode();
        so.opsteIzvrsenje();
        return so.getProizvodi();
    } 
    
    
    public void sacuvajRacun(Racun r) throws Exception{
         try {
            dbbr.uspostaviKonekciju();
            dbbr.sacuvajRacun(r);
            for(StavkaRacuna stavka:r.getStavke()){
                dbbr.sacuvajStavku(stavka);
            }
            dbbr.potvrdiTransakciju();
        } catch (SQLException sqle) {
            dbbr.ponistiTransakciju();
        }
                
    }

    public void sacuvajPartnera(PoslovniPartner partner) throws Exception {
        /*
        try {
            dbbr.uspostaviKonekciju();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        try{
            //preduslovi
            dbbr.sacuvajPartnera(partner);
            dbbr.potvrdiTransakciju();
        } catch (Exception sqle) {
            sqle.printStackTrace();
            dbbr.ponistiTransakciju();
            throw sqle;
        }finally{
            dbbr.raskiniKonekciju();
        }
        */
        SOSacuvajPartnera so=new SOSacuvajPartnera(partner);
        so.opsteIzvrsenje();
    }
    
    
    public void sacuvajListuPartnera(List<PoslovniPartner> partneri) throws Exception {
        //listaPartnera.add(partner);
        /*
        try {
            dbbr.uspostaviKonekciju();

            for (PoslovniPartner partner : partneri) {
                dbbr.sacuvajPartnera(partner);
            }
            
                       
            
            dbbr.potvrdiTransakciju();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            dbbr.ponistiTransakciju();
            throw sqle;
        }
        */
        SOSacuvajListuPoslovnihPartnera so=new SOSacuvajListuPoslovnihPartnera(partneri);
        so.opsteIzvrsenje();
    }
    

//    public List<PoslovniPartner> vratiSvePartnere() {
//        return listaPartnera;
//    }

}
