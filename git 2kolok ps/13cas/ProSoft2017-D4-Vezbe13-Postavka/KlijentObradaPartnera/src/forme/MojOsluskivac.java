/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.PoslovniPartner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author student
 */
public class MojOsluskivac implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Desio se klik");
        PoslovniPartner partner = new PoslovniPartner();
        //partner.setMaticniBroj();
    }
    
}
