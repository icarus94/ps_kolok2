/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import javax.swing.JTextField;

/**
 *
 * @author student
 */
public class NitBingo extends Thread {

    JTextField jTxtBr1;
    JTextField jTxtBr2;
    JTextField jTxtBr3;

    public NitBingo(JTextField jTxtBr1, JTextField jTxtBr2, JTextField jTxtBr3) {
        this.jTxtBr1 = jTxtBr1;
        this.jTxtBr2 = jTxtBr2;
        this.jTxtBr3 = jTxtBr3;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            double br1 = Math.random();
            int broj1 = (int) (br1 * 10);
            jTxtBr1.setText(broj1 + "");

            double br2 = Math.random();
            int broj2 = (int) (br2 * 10);
            jTxtBr2.setText(broj2 + "");

            double br3 = Math.random();
            int broj3 = (int) (br3 * 10);
            jTxtBr3.setText(broj3 + "");
        }

    }

}
