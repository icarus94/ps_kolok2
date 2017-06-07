/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbbr.DBBroker;

/**
 *
 * @author student
 */
public abstract class OpstaSO {

    protected DBBroker dbbr;

    public OpstaSO() {
        dbbr = new DBBroker();
    }

    public final void opsteIzvrsenjeSO(Object o) throws Exception {
        try {
            uspostaviKonekciju();
            proveriPreduslov(o);
            izvrsiOperaciju(o);
            commitTransakcije();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransakcije();
            throw ex;
        }
    }

    private void uspostaviKonekciju() throws Exception {
        dbbr.uspostaviKonekciju();
    }

    // Specificno za svaku sistemsku operaciju
    protected abstract void proveriPreduslov(Object o) throws Exception;

    // Specificno za svaku sistemsku operaciju
    protected abstract void izvrsiOperaciju(Object o) throws Exception;

    private void commitTransakcije() throws Exception {
        dbbr.potvrdiTransakciju();
    }

    private void rollbackTransakcije() throws Exception {
        dbbr.ponistiTransakciju();
    }

}
