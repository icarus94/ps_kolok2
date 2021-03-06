/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Kategorija;
import domen.Korisnik;
import java.awt.Color;
import server.PokretanjeServera;

/**
 *
 * @author Miroslav
 */
public class ServerskaForma extends javax.swing.JFrame {

    /**
     * Creates new form ServerskaForma
     */
    public ServerskaForma() {
        initComponents();
        PokretanjeServera ps = new PokretanjeServera(this);
        ps.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelaUlogovaniKorisnici = new javax.swing.JLabel();
        labelaRec = new javax.swing.JLabel();
        labelaBrojPokusaja = new javax.swing.JLabel();
        labelaServer = new javax.swing.JLabel();
        labelaIzabranaKategorija = new javax.swing.JLabel();
        labelaZvezdice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelaUlogovaniKorisnici.setText("jLabel1");

        labelaRec.setText("jLabel1");

        labelaBrojPokusaja.setText("jLabel2");

        labelaServer.setText("jLabel1");

        labelaIzabranaKategorija.setText("jLabel1");

        labelaZvezdice.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(labelaServer)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelaZvezdice)
                    .addComponent(labelaIzabranaKategorija)
                    .addComponent(labelaBrojPokusaja)
                    .addComponent(labelaRec)
                    .addComponent(labelaUlogovaniKorisnici))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelaUlogovaniKorisnici)
                .addGap(18, 18, 18)
                .addComponent(labelaRec)
                .addGap(18, 18, 18)
                .addComponent(labelaBrojPokusaja)
                .addGap(18, 18, 18)
                .addComponent(labelaIzabranaKategorija)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelaZvezdice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(labelaServer)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelaBrojPokusaja;
    private javax.swing.JLabel labelaIzabranaKategorija;
    private javax.swing.JLabel labelaRec;
    private javax.swing.JLabel labelaServer;
    private javax.swing.JLabel labelaUlogovaniKorisnici;
    private javax.swing.JLabel labelaZvezdice;
    // End of variables declaration//GEN-END:variables

    public void pokrenutJE() {
        labelaServer.setText("Server se pokrenuo");
        labelaServer.setForeground(Color.green);
    }

    public void nijePokrenut() {
        labelaServer.setText("Server se nije pokrenuo");
        labelaServer.setForeground(Color.red);
    }

    public void setPodaci(String zadataRec, String zadataRecSaZvezdicama, int brojPokusaja, Korisnik k, Kategorija kat) {
        labelaBrojPokusaja.setText(brojPokusaja+"");
        labelaUlogovaniKorisnici.setText(k.toString());
        labelaRec.setText(zadataRec);
        labelaIzabranaKategorija.setText(kat.toString());
        labelaZvezdice.setText(zadataRecSaZvezdicama);
    }
}
