/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponente.model;

import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class RacunModelTabele extends AbstractTableModel  {

    private Racun racun;
    String[] naziviKolona = {"rb", "sifra", "naziv", "cena", "kolicina"};
    
    public RacunModelTabele() {
        racun = new Racun();
    }

    public RacunModelTabele(Racun racun) {
        this.racun = racun;
    }
    
    
    
    @Override
    public int getRowCount() {
        return racun.getStavke().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna stavka = racun.getStavke().get(rowIndex);
        switch(columnIndex){
            case 0: return stavka.getRb();
            case 1: return stavka.getProizvod().getStfra();
            case 2: return stavka.getProizvod().getNaziv();
            case 3: return stavka.getProizvod().getCena();
            case 4: return stavka.getKolicina();
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    
    
}
