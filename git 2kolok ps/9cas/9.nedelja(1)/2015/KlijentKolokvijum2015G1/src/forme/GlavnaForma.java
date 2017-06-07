/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import validation.Validator;

/**
 *
 * @author Miroslav
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    
    ArrayList<Character> listaKaraktera;
    
    public GlavnaForma() {
        initComponents();
        listaKaraktera = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBrPokusaja = new javax.swing.JTextField();
        txtSlovo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        labelaListaSlova = new javax.swing.JLabel();
        krajIgre = new javax.swing.JLabel();
        labelaZadataRec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BrojPokusaja");

        txtBrPokusaja.setEnabled(false);

        jButton1.setText("Posalji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        krajIgre.setText("IGRA JE U TOKU");

        labelaZadataRec.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelaZadataRec)
                    .addComponent(krajIgre)
                    .addComponent(labelaListaSlova, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtSlovo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtBrPokusaja, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(krajIgre)
                .addGap(18, 18, 18)
                .addComponent(labelaZadataRec)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSlovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addComponent(labelaListaSlova, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBrPokusaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String slovo = txtSlovo.getText();
        if(Validator.getInstanca().checkSlovo(slovo) && !listaKaraktera.contains(slovo.toUpperCase().charAt(0))){
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.POSALJI);
            kz.setSlovo(slovo.toUpperCase().charAt(0));
            listaKaraktera.add(slovo.toUpperCase().charAt(0));
            
            KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
            
            ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
            
            setPodaci(so);
            if(so.isKraj()){
                krajIgre.setText("KRAJ");
                JOptionPane.showMessageDialog(this, so.getPoruka());
            }
            
        }else{
            System.out.println("GRESKA");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaForma().setVisible(true);
            }
        });
    }
    
    public void setPodaci(ServerskiOdgovor so){
        labelaZadataRec.setText(so.getZadataRec());
        txtBrPokusaja.setText(so.getBrojPokusaja() + "");
        String nalepi = "";
        for (Character c : listaKaraktera) {
            nalepi+=c;
        }
        labelaListaSlova.setText(nalepi);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel krajIgre;
    private javax.swing.JLabel labelaListaSlova;
    private javax.swing.JLabel labelaZadataRec;
    private javax.swing.JTextField txtBrPokusaja;
    private javax.swing.JTextField txtSlovo;
    // End of variables declaration//GEN-END:variables
}
