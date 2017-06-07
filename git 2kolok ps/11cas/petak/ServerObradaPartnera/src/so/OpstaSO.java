/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbbr.DBBroker;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public abstract class OpstaSO {
    
     DBBroker dbbr;

    public OpstaSO(DBBroker dbbr) {
        this.dbbr = dbbr;
    }

    public void opsteIzvrsenjeSO() throws Exception {
         try {
             dbbr.uspostaviKonekciju();
             proveriPreduslovSO();
             konkretnoIzvrsenjeSO();
             dbbr.potvrdiTransakciju();
         } catch (Exception ex) {
             dbbr.ponistiTransakciju();
             throw ex;
         }
        
    }
    

    public void proveriPreduslovSO() throws Exception {
        System.out.println("NEMA PREDUSLOVA!");
    }

    public abstract void konkretnoIzvrsenjeSO() throws Exception;
        
    
    
}
