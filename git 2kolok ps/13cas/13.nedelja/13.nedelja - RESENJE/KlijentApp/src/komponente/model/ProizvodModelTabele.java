/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponente.model;

import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class ProizvodModelTabele extends AbstractTableModel  {

    private List<Proizvod> proizvodi;
    String[] naziviKolona = {"sifra", "naziv", "cena"};

    public ProizvodModelTabele(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }
    
    
    @Override
    public int getRowCount() {
        return proizvodi.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvod proizvod = proizvodi.get(rowIndex);
        switch(columnIndex){
            case 0: return proizvod.getStfra();
            case 1: return proizvod.getNaziv();
            case 2: return proizvod.getCena();
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public Proizvod vratiProizvod(int red) {
        return proizvodi.get(red);
    }

    
    
}
