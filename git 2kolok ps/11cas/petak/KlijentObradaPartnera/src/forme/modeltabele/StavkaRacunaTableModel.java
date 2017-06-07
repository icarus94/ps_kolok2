/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.modeltabele;

import domen.PoslovniPartner;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class StavkaRacunaTableModel extends AbstractTableModel {
    
    
    Racun racun;

    public StavkaRacunaTableModel(Racun racun) {
        this.racun = racun;
    }

    @Override
    public int getRowCount() {
        return racun.getStavke().size();
    }
    
    String naziviKolona[] = {"Rb.","Proizvod","Kolicina","Cena","Iznos"};

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            
         StavkaRacuna stavka = racun.getStavke().get(rowIndex);
        
        switch (columnIndex){
            
            case 0: return stavka.getRb();
            
            case 1: return stavka.getProizvod().getNaziv();
            
            case 2: return stavka.getKolicina();
            
            case 3: return stavka.getCena();
            
            case 4: return stavka.getIznos();            
            
            default: return "N/A";
        }
        

    }
    
    public void dodajStavku(Proizvod p, double kolicina){
        
        StavkaRacuna stavka = new StavkaRacuna();
        stavka.setRacun(racun);
        
        stavka.setProizvod(p);
        stavka.setKolicina(kolicina);
        stavka.setCena(p.getCena());
        
        stavka.setIznos(kolicina*p.getCena());
        
        racun.getStavke().add(stavka);
        fireTableDataChanged();
        
        
    }

    public Racun getRacun() {
        return racun;
    }
    
    
    
    
}
