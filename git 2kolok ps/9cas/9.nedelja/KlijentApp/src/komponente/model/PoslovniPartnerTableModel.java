/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponente.model;

import domen.PoslovniPartner;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class PoslovniPartnerTableModel extends AbstractTableModel{
    List<PoslovniPartner> partneri;
    String[] naziviKolona = {"pib", "maticni broj", "naziv", "adresa", "mesto"};

    public PoslovniPartnerTableModel(List<PoslovniPartner> partneri) {
        this.partneri = partneri;
    }
     
    @Override
    public int getRowCount() {
        if(partneri==null) return 0;
        return partneri.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoslovniPartner pp = partneri.get(rowIndex);
        switch(columnIndex){
            case 0: return pp.getPib();
            case 1: return pp.getMaticniBroj();
            case 2: return pp.getNaziv();
            case 3: return pp.getUlica() + " " + pp.getBroj();
            case 4: return pp.getMesto();
            default:return "N/A";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void dodajNoviRed(PoslovniPartner partner) {
        partneri.add(partner);
        fireTableDataChanged();
    }

    public List<PoslovniPartner> vratiPodatke() {
        return partneri;
    }
    
    
    
}
