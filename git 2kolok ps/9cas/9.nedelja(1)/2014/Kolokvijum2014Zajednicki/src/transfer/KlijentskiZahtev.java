/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Miroslav
 */
public class KlijentskiZahtev implements Serializable{
     private int operacija;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija) {
        this.operacija = operacija;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
     
     
}
