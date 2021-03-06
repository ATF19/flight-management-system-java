/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import java.util.LinkedHashMap;
import java.util.Map;
import static myPackage.Main.db;
import org.neo4j.graphdb.Result;

/**
 *
 * @author Atef
 */
public class ModifierEmp extends javax.swing.JFrame {
    private int post;
    private String type;
    /**
     * Creates new form ModifierEmp
     */
    public ModifierEmp() {
        initComponents();
    }

    public void loadDb(int pos, String type) {
        post= pos;
        this.type = type;
        Result res = db.execute("MATCH (n:Personnel {cin:"+pos+"}) RETURN n.cin, n.numPassport, n.nom, n.adresse, n.telephone");
        String test[] = {"n.cin", "n.numPassport", "n.nom", "n.adresse", "n.telephone"};
        Map<String, Object> obj = new LinkedHashMap();
        while(res.hasNext()) {
            Map<String, Object> row = res.next();
            for (String t:test) {
                obj.put(t, null);
            }
            for(Map.Entry<String, Object> col : row.entrySet()) {
                 obj.put(col.getKey(),col.getValue());   
            }
        }
        res.close();
        cin.setText(obj.get("n.cin").toString());
        passeport.setText(obj.get("n.numPassport").toString());
        nom.setText(obj.get("n.nom").toString());
        tel.setText(obj.get("n.telephone").toString());
        adresse.setText(obj.get("n.adresse").toString());
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tel = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passeport = new javax.swing.JTextField();
        cin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modifier un employee");

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Telephone:");

        jLabel4.setText("Adrese:");

        jLabel3.setText("Prenom:");

        jLabel2.setText("Nom:");

        jLabel7.setText("Passeport:");

        jLabel1.setText("CIN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adresse, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prenom, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nom, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passeport))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(passeport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Result upd = db.execute("MATCH (n:Personne {cin:"+post+"}) SET n.cin='"+cin.getText()+"', n.numPassport='"+passeport.getText()+"', n.nom='"+nom.getText()+" "+prenom.getText()+"', n.adresse='"+adresse.getText()+"', n.telephone='"+tel.getText()+"' RETURN n");
         upd = db.execute("MATCH (n:Personnel {cin:"+post+"}) SET n.cin='"+cin.getText()+"', n.numPassport='"+passeport.getText()+"', n.nom='"+nom.getText()+" "+prenom.getText()+"', n.adresse='"+adresse.getText()+"', n.telephone='"+tel.getText()+"' RETURN n");
         upd = db.execute("MATCH (n:NonNaviguant {cin:"+post+"}) SET n.cin='"+cin.getText()+"', n.numPassport='"+passeport.getText()+"', n.nom='"+nom.getText()+" "+prenom.getText()+"', n.adresse='"+adresse.getText()+"', n.telephone='"+tel.getText()+"' RETURN n");
         upd = db.execute("MATCH (n:Naviguant {cin:"+post+"}) SET n.cin='"+cin.getText()+"', n.numPassport='"+passeport.getText()+"', n.nom='"+nom.getText()+" "+prenom.getText()+"', n.adresse='"+adresse.getText()+"', n.telephone='"+tel.getText()+"' RETURN n");
          upd = db.execute("MATCH (n:Pilote {cin:"+post+"}) SET n.cin='"+cin.getText()+"', n.numPassport='"+passeport.getText()+"', n.nom='"+nom.getText()+" "+prenom.getText()+"', n.adresse='"+adresse.getText()+"', n.telephone='"+tel.getText()+"' RETURN n");
         if (!upd.hasNext()) {
            ErrorFen errf = new ErrorFen();
            errf.setLocationRelativeTo(null);
            errf.setError("Probleme dans l'insertion");
            errf.setVisible(true);
        }
        else this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JTextField cin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField passeport;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField tel;
    // End of variables declaration//GEN-END:variables
}
