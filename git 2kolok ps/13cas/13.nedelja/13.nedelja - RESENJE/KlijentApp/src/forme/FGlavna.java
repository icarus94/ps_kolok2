/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author student
 */
public class FGlavna extends javax.swing.JFrame {

    /**
     * Creates new form FGlavna
     */
    public FGlavna() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmPoslovniPartner = new javax.swing.JMenu();
        jmiUnosPP = new javax.swing.JMenuItem();
        jmiPretragaPP = new javax.swing.JMenuItem();
        jmRacun = new javax.swing.JMenu();
        jmiNoviRacun = new javax.swing.JMenuItem();
        jmOAplikaciji = new javax.swing.JMenu();
        jmiOAutoru = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moja aplikacija");

        jmPoslovniPartner.setText("Poslovni partner");

        jmiUnosPP.setText("Unos");
        jmiUnosPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosPPActionPerformed(evt);
            }
        });
        jmPoslovniPartner.add(jmiUnosPP);

        jmiPretragaPP.setText("Pretraga");
        jmiPretragaPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaPPActionPerformed(evt);
            }
        });
        jmPoslovniPartner.add(jmiPretragaPP);

        jMenuBar1.add(jmPoslovniPartner);

        jmRacun.setText("Racun");
        jmRacun.setToolTipText("");

        jmiNoviRacun.setText("Novi racun");
        jmiNoviRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNoviRacunActionPerformed(evt);
            }
        });
        jmRacun.add(jmiNoviRacun);

        jMenuBar1.add(jmRacun);

        jmOAplikaciji.setText("O aplikaciji");

        jmiOAutoru.setText("O autoru");
        jmOAplikaciji.add(jmiOAutoru);

        jMenuBar1.add(jmOAplikaciji);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUnosPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosPPActionPerformed
        try {
            JDialog fpp = new FPoslovniPartner(this, true);
            fpp.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(FGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmiUnosPPActionPerformed

    private void jmiPretragaPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaPPActionPerformed
       JDialog forma = new FPretragaPoslovniPartner(this, true);
       forma.setVisible(true);
    }//GEN-LAST:event_jmiPretragaPPActionPerformed

    private void jmiNoviRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNoviRacunActionPerformed
        // TODO add your handling code here:
        JDialog forma = new FMRacun(this, true);
        forma.setVisible(true);
    }//GEN-LAST:event_jmiNoviRacunActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmOAplikaciji;
    private javax.swing.JMenu jmPoslovniPartner;
    private javax.swing.JMenu jmRacun;
    private javax.swing.JMenuItem jmiNoviRacun;
    private javax.swing.JMenuItem jmiOAutoru;
    private javax.swing.JMenuItem jmiPretragaPP;
    private javax.swing.JMenuItem jmiUnosPP;
    // End of variables declaration//GEN-END:variables
}
