/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import forme.modeltabele.PartneriTableModel;
import domen.PoslovniPartner;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import poslovnaLogika.KontrolerPL;

/**
 *
 * @author student
 */
public class JDPrikazPartnera extends javax.swing.JDialog {

    /**
     * Creates new form JDPrikazPartnera
     */
    public JDPrikazPartnera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartneri = new javax.swing.JTable();
        btnDodajPartnera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPartneri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maticni broj", "Naziv", "PIB", "Ulica", "Broj", "Mesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPartneri);

        btnDodajPartnera.setText("Dodaj");
        btnDodajPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPartneraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDodajPartnera)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnDodajPartnera)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPartneraActionPerformed
        // TODO add your handling code here:
        PartneriTableModel ptm = (PartneriTableModel) tblPartneri.getModel();
        ptm.dodajNoviRed();
    }//GEN-LAST:event_btnDodajPartneraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDPrikazPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDPrikazPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDPrikazPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDPrikazPartnera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDPrikazPartnera dialog = new JDPrikazPartnera(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPartnera;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPartneri;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        
        try {
            KontrolerPL kontroler = KontrolerPL.vratiInstancu();
            
            
            List<PoslovniPartner> listaPartnera = kontroler.vratiSvePartnere();
            
            tblPartneri.setModel(new PartneriTableModel(listaPartnera));
            
            /*
            DefaultTableModel dtm = (DefaultTableModel) tblPartneri.getModel();
            
            
            Object [] podaci;
            for (PoslovniPartner poslovniPartner : listaPartnera) {
            
            podaci = new Object[6];
            
            podaci[0] = poslovniPartner.getMaticniBroj();
            podaci[1] = poslovniPartner.getNaziv();
            podaci[2] = poslovniPartner.getPib();
            podaci[3] = poslovniPartner.getUlica();
            podaci[4] = poslovniPartner.getBroj();
            podaci[5] = poslovniPartner.getMesto();
            
            dtm.addRow(podaci);
            
            }
            
            */
        } catch (SQLException ex) {
            Logger.getLogger(JDPrikazPartnera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
