/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelitabele;

/**
 *
 * @author vojkan
 */
public class KorisnikView {
    
    
    String nick;
    int brojPoruka;

    public KorisnikView(String nick) {
        this.nick = nick;
        brojPoruka =0;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getBrojPoruka() {
        return brojPoruka;
    }

    public void setBrojPoruka(int brojPoruka) {
        this.brojPoruka = brojPoruka;
    }
    
    public void povecajBrojPoruka(){        
        this.brojPoruka++;
    }
    
    
}
