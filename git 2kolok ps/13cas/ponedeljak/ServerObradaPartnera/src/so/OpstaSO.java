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

    public OpstaSO() {
        dbbr = new DBBroker();
    }
    
    
    
    public void opsteIzvrsenjeSO() throws Exception{        
        
        try {
            dbbr.uspostaviKonekciju();
            
            proveriPreduslovSO();
            
            konkretnoIzvrsenjeSO();
            
            dbbr.potvrdiTransakciju();
            
        } catch (Exception ex) {
            Logger.getLogger(OpstaSO.class.getName()).log(Level.SEVERE, null, ex);
            dbbr.ponistiTransakciju();
            throw ex;
        }finally{
         dbbr.zatvoriKonekciju();   
            
        }
        
        
    }

    public abstract void proveriPreduslovSO() throws Exception;

    public abstract void konkretnoIzvrsenjeSO() throws Exception;
    
    
    
}
