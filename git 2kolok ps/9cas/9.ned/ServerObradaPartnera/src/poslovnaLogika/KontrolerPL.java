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

/**
 *
 * @author student
 */
public class KontrolerPL {

    List<Mesto> listaMesta;
    List<PoslovniPartner> listaPartnera;

    DBBroker dbbr;

    private static KontrolerPL instanca;

    public static KontrolerPL vratiInstancu() {

        if (instanca == null) {
            instanca = new KontrolerPL();
        }

        return instanca;
    }

    private KontrolerPL() {
        listaMesta = new ArrayList<>();
        listaPartnera = new ArrayList<>();
        inicijalizujMesta();
        dbbr = new DBBroker();

    }

    private void inicijalizujMesta() {
        listaMesta.add(new Mesto(11000, "Beograd"));
        listaMesta.add(new Mesto(11070, "Novi Beograd"));
        listaMesta.add(new Mesto(11010, "Vozdovac"));
        listaMesta.add(new Mesto(35230, "Cuprija"));
        listaMesta.add(new Mesto(11250, "Zeleznik"));
    }

    public List<Mesto> vratiSvaMesta() throws Exception {
        //return listaMesta;
        dbbr.uspostaviKonekciju();
        return dbbr.vratiSvaMesta();
    }
    
     public List<PoslovniPartner> vratiSvePartnere() throws Exception {
        //return listaMesta;
        dbbr.uspostaviKonekciju();
        return dbbr.vratiSvePartnere();
    }
     
    public List<Proizvod> vratiSveProizvode() throws Exception {
        //return listaMesta;
        dbbr.uspostaviKonekciju();
        return dbbr.vratiSveProizvode();
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
        //listaPartnera.add(partner);
        try {
            dbbr.uspostaviKonekciju();
            dbbr.sacuvajPartnera(partner);
            dbbr.potvrdiTransakciju();
        } catch (SQLException sqle) {
            dbbr.ponistiTransakciju();
        }
    }
    
    
    public void sacuvajListuPartnera(List<PoslovniPartner> partneri) throws Exception {
        //listaPartnera.add(partner);
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
    }
    

//    public List<PoslovniPartner> vratiSvePartnere() {
//        return listaPartnera;
//    }

}
