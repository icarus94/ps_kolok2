/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;
import pomoc.TabelaKlasa;

/**
 *
 * @author Miroslav
 */
public class ModelTabele extends AbstractTableModel{
    
    ArrayList<TabelaKlasa> lista = new ArrayList<>();

    public ModelTabele() {
        for (int i = 0; i < 10; i++) {
            int broj = (int)(Math.random() * 31);
            TabelaKlasa tk = new TabelaKlasa(i+ 1, broj);
            lista.add(tk);
        }
    }
    
    

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return lista.get(columnIndex).getBrojVrednosti();
    }

    @Override
    public String getColumnName(int column) {
        return (column +1)+"";
    }

    public String odradiPosaoKojiTrebaS(int pozicija, String korisnickoIme) {
        int broj = (int)(Math.random() * 31);
        int minBroj = Integer.MAX_VALUE;
        
        for (TabelaKlasa tk : lista) {
            if(tk.getBrojKolone() != pozicija){
                if(tk.getBrojVrednosti()%3 == 0){
                    if(minBroj>tk.getBrojVrednosti()){
                        minBroj=tk.getBrojVrednosti();
                    }
                }
            }
        }
        if(minBroj != Integer.MAX_VALUE){
            broj = minBroj;
        }
        int stariBroj = 0;
        for (TabelaKlasa tk : lista) {
            if(tk.getBrojKolone() == pozicija){
                stariBroj = tk.getBrojVrednosti();
                tk.setBrojVrednosti(broj);
            }
        }
        Collections.sort(lista, new Comparator<TabelaKlasa>() {
            @Override
            public int compare(TabelaKlasa o1, TabelaKlasa o2) {
                return Integer.compare(o1.getBrojKolone(), o2.getBrojKolone());
            }
        });
        
        fireTableDataChanged();
        String poruka =korisnickoIme +" je izbacio el. sa pozicije <"+pozicija+">("+stariBroj+"), sada je na toj poziciji broj "+ broj;
        return poruka;
    }
    
}
