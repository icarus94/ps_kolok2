/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vojkan
 */
public class TableModelLogovaniKorisnici extends AbstractTableModel implements  OsluskivacDogadjaja{

    List<KorisnikView> listaUlogovanihKorisnika;

    public TableModelLogovaniKorisnici(List<KorisnikView> listaUlogovanihKorisnika) {
        this.listaUlogovanihKorisnika = listaUlogovanihKorisnika;
    }
    
    
    
    String naziviKolona[] = {"Korisnik","Broj poslatih poruka"};

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    
    
    @Override
    public int getRowCount() {
        return listaUlogovanihKorisnika.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        KorisnikView korisnikView = listaUlogovanihKorisnika.get(rowIndex);
        
        switch(columnIndex){
         
            case 0: return korisnikView.getNick();
            
            case 1: return korisnikView.brojPoruka;
            
        }
        
        return "N/A";
        
    }

    @Override
    public void desioSeDogadjaj(NoviDogadjaj noviDogadjaj) {
        switch(noviDogadjaj.tipDogadjaja){
            
            case NoviDogadjaj.KORISNIK_SE_PRIJAVIO:
                KorisnikView prijavljeniKorisnik = new KorisnikView(noviDogadjaj.nick);
                listaUlogovanihKorisnika.add(prijavljeniKorisnik);
                fireTableRowsInserted(listaUlogovanihKorisnika.size()-1, listaUlogovanihKorisnika.size()-1);
                break;
                
            case NoviDogadjaj.KORISNIK_POSLAO_PORUKU:
                int indexKorisnika =pronadjiIndexKorisnikaPoNicku(noviDogadjaj.nick);
                if (indexKorisnika!=-1) listaUlogovanihKorisnika.get(indexKorisnika).povecajBrojPoruka();
                fireTableRowsUpdated(indexKorisnika, indexKorisnika);
                break;
                
            case NoviDogadjaj.KORISNIK_SE_ODJAVIO:    
                int index =pronadjiIndexKorisnikaPoNicku(noviDogadjaj.nick);
                if (index!=-1) listaUlogovanihKorisnika.remove(index);
                fireTableRowsDeleted(index, index);
                break;
        }
    }
    
    private int pronadjiIndexKorisnikaPoNicku(String nick){
        
        for (int i = 0; i < listaUlogovanihKorisnika.size(); i++) {
            KorisnikView tekKorisnik = listaUlogovanihKorisnika.get(i);
            
            if (tekKorisnik.nick.equalsIgnoreCase(nick)){
                    return i;
            }
        }
        
        return -1;   
    }
    
    
    
    
    
}
