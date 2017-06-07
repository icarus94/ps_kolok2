/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.modeltabele;

import domen.Proizvod;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class ProizvodiTableModel extends AbstractTableModel {

    List<Proizvod> filtriranaListaProizvoda;

    List<Proizvod> inicijalnaListaProizvoda;

    public ProizvodiTableModel(List<Proizvod> listaProizvoda) {
        this.filtriranaListaProizvoda = listaProizvoda;
        this.inicijalnaListaProizvoda = listaProizvoda;
    }

    @Override
    public int getRowCount() {
        return filtriranaListaProizvoda.size();
    }

    String naziviKolona[] = {"sifra", "naziv", "cena"};

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Proizvod p = filtriranaListaProizvoda.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getSifra();

            case 1:
                return p.getNaziv();

            case 2:
                return p.getCena();

            default:
                return "N/A";
        }
    }

    public void fltrirajProizvode(String naziv) {
        
        filtriranaListaProizvoda = new ArrayList<>();
        
        if (naziv.isEmpty()) {
            filtriranaListaProizvoda = inicijalnaListaProizvoda;
        } else {

            for (int i = 0; i < inicijalnaListaProizvoda.size(); i++) {
                Proizvod p = inicijalnaListaProizvoda.get(i);
                if (p.getNaziv().toLowerCase().startsWith(naziv.toLowerCase())) {
                    filtriranaListaProizvoda.add(p);
                }
            }
        }
        fireTableDataChanged();
    }
    
    public Proizvod vratiProizvod(int selRed){
        return filtriranaListaProizvoda.get(selRed);
    }

}
