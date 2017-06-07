/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Miroslav
 */
public class Slovo implements Serializable{
    private String slovo;
    private int poena;

    public Slovo() {
    }

    public Slovo(String slovo, int poena) {
        this.slovo = slovo;
        this.poena = poena;
    }

    public int getPoena() {
        return poena;
    }

    public void setPoena(int poena) {
        this.poena = poena;
    }

    public String getSlovo() {
        return slovo;
    }

    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Slovo other = (Slovo) obj;
        if (!Objects.equals(this.slovo, other.slovo)) {
            return false;
        }
        return true;
    }
    
    
}
