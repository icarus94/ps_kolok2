/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomoc;

/**
 *
 * @author Miroslav
 */
public class TabelaKlasa {
    private int brojKolone;
    private int brojVrednosti;

    public TabelaKlasa() {
    }

    public TabelaKlasa(int brojKolone, int brojVrednosti) {
        this.brojKolone = brojKolone;
        this.brojVrednosti = brojVrednosti;
    }

    public int getBrojVrednosti() {
        return brojVrednosti;
    }

    public void setBrojVrednosti(int brojVrednosti) {
        this.brojVrednosti = brojVrednosti;
    }

    public int getBrojKolone() {
        return brojKolone;
    }

    public void setBrojKolone(int brojKolone) {
        this.brojKolone = brojKolone;
    }
    
    
}
