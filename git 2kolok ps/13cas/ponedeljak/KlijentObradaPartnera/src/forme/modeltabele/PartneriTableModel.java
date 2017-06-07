/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.modeltabele;

import domen.Mesto;
import domen.PoslovniPartner;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class PartneriTableModel extends AbstractTableModel{

    List<PoslovniPartner> listaPartnera;

    public PartneriTableModel(List<PoslovniPartner> listaPartnera) {
        this.listaPartnera = listaPartnera;
    }

    
    String [] naziviKolona = new String[]{"Maticni broj","Naziv","PIB","Ulica","Broj","Mesto"};
    
    @Override
    public String getColumnName(int column) {
        return naziviKolona[column]; //To change body of generated methods, choose Tools | Templates.
    }
      
        
    
    @Override
    public int getRowCount() {
        return listaPartnera.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        PoslovniPartner partner = listaPartnera.get(rowIndex);
        
        switch (columnIndex){
            
            case 0: return partner.getMaticniBroj();
            
            case 1: return partner.getNaziv();
            
            case 2: return partner.getPib();
            
            case 3: return partner.getUlica();
            
            case 4: return partner.getBroj();
            
            case 5: return partner.getMesto();
            
            default: return "N/A";
        }
        
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        PoslovniPartner partner = listaPartnera.get(rowIndex);
        
        switch(columnIndex){
            
            case 0: partner.setMaticniBroj(aValue.toString());
                    break;
            
            case 1: partner.setNaziv(aValue.toString());
                    break;
            
            case 2:partner.setPib(aValue.toString());
                    break;
                    
            case 3:partner.setUlica(aValue.toString());
                    break;
                    
            case 4:partner.setBroj(aValue.toString());
                    break;
            
            case 5: partner.setMesto((Mesto) aValue);
                    break;
            
        }
        
    }
    
    
    public void dodajNoviRed(){
        
        listaPartnera.add(new PoslovniPartner());
        System.out.println("Lista partnera:"+listaPartnera);
        fireTableRowsInserted(listaPartnera.size()-1, listaPartnera.size()-1);
        
    }
    
    public void obrisiRed(int red){
        listaPartnera.remove(red);
        fireTableRowsDeleted(red, red);        
    }

    public List<PoslovniPartner> vratiListuPartnera() {
        return listaPartnera;
    }

    public void setListaPartnera(List<PoslovniPartner> listaPartnera) {
        this.listaPartnera = listaPartnera;
        fireTableDataChanged();
    }
    
    
    
    
    
}
