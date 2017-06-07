/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.modelitabele;

import domen.Poruka;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vojkan
 */
public class TableModelPoruka extends AbstractTableModel {

    List<Poruka> listaPoruka;

    public TableModelPoruka(List<Poruka> listaPoruka) {
        this.listaPoruka = listaPoruka;
    }
    
    
    String naziviKolona[] = {"Posiljalac","Tekst poruke"};

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    
      
    @Override
    public int getRowCount() {
        return listaPoruka.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Poruka p = listaPoruka.get(rowIndex);
        
        switch(columnIndex){
            
            case 0: return p.getOdKogajePoruka();

            case 1:return p.getPoruka();
            
        }
        
        return "N/A";
        
    }
    
    
    
    public void dodajPoruku(Poruka p){
        listaPoruka.add(p);
        fireTableRowsInserted(listaPoruka.size()-1, listaPoruka.size()-1);
        
    }
}
