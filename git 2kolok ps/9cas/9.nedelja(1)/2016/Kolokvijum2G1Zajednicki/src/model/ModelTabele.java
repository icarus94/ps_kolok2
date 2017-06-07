/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Slovo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miroslav
 */
public class ModelTabele extends AbstractTableModel{
    ArrayList<Slovo> lista;

    public ModelTabele(ArrayList<Slovo> lista) {
        this.lista = lista;
    }

    public ModelTabele() {
        lista = new ArrayList<>();
    }

    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Slovo s = lista.get(rowIndex);
        
        if(columnIndex == 0){
            return s.getSlovo();
        }
        if(columnIndex == 1){
            return s.getPoena();
        }
        
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0){
            return "Slovo";
        }
        if(column == 1){
            return "Poeni";
        }
        
        return "";
    }

    public void dodajSlovo(Slovo slovo) {
        lista.add(slovo);
        fireTableDataChanged();
                
    }

    
}
