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
public class NoviDogadjaj {
    
    public static final int KORISNIK_SE_PRIJAVIO=1;
    public static final int KORISNIK_POSLAO_PORUKU=2;
    public static final int KORISNIK_SE_ODJAVIO=3;
    
    String nick;
    int tipDogadjaja;

    public NoviDogadjaj(String nick, int tipDogadjaja) {
        this.nick = nick;
        this.tipDogadjaja = tipDogadjaja;
    }
    
    
}
