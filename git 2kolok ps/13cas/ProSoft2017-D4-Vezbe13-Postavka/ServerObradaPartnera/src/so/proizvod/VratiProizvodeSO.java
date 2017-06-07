/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proizvod;

import domen.Proizvod;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author student
 */
public class VratiProizvodeSO extends OpstaSO {
    private List<Proizvod> proizvodi;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova za vracanje liste proizvoda.");
    }

    @Override
    protected void izvrsiOperaciju(Object o) throws Exception {
        proizvodi = dbbr.vratiSveProizvode();
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }
}
