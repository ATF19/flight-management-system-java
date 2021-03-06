/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import static myPackage.Main.db;
import org.neo4j.graphdb.Result;

/**
 *
 * @author Atef
 */
public class AjouterDepart extends javax.swing.JFrame {

    /**
     * Creates new form AjouterDepart
     */
    public AjouterDepart() {
        initComponents();
        
    }

    public void loadTableBD() {
        Result res = db.execute("MATCH (n:`Vol`) RETURN n.numero, n.villeDep, n.villeArr, n.heureDep, n.heureArr, n.distance, n.frequence ORDER BY n.numero");
        String test[] = {"n.numero", "n.villeDep", "n.villeArr", "n.heureDep", "n.heureArr", "n.distance", "n.frequence"};
        while ( res.hasNext() ) {
            Map<String,Object> row = res.next();
            Map<String, Object> mp = new HashMap();
            for ( Entry<String,Object> column : row.entrySet() )
            {
                mp.put(column.getKey(), column.getValue());
            }
            volList.addItem(mp.get("n.numero"));
        }
        res = db.execute("MATCH (n:`Avion`) RETURN n.numero, n.type, n.capacite");
        while ( res.hasNext() ) {
            Map<String,Object> row = res.next();
            Map<String, Object> mp = new HashMap();
            for ( Entry<String,Object> column : row.entrySet() )
            {
                mp.put(column.getKey(), column.getValue());
            }
            avionList.addItem(mp.get("n.numero"));
        }
        res = db.execute("MATCH (n:`Passager`) RETURN n.cin, n.numPassport, n.nom, n.adresse, n.telephone");
        DefaultListModel<String> model = new DefaultListModel();
        while ( res.hasNext() ) {
            Map<String,Object> row = res.next();
            
            
            Map<String, Object> mp = new HashMap();
            for ( Entry<String,Object> column : row.entrySet() )
            {
                mp.put(column.getKey(), column.getValue());
            }
            
            model.addElement(mp.get("n.cin")+"");
            
        }
        passagersList.setModel(model);
        res = db.execute("MATCH (n:`Personnel`) RETURN n.cin, n.numPassport, n.nom, n.adresse, n.telephone, n.type");
        DefaultListModel<String> model2 = new DefaultListModel();
        while ( res.hasNext() ) {
            Map<String,Object> row = res.next();
            
            
            Map<String, Object> mp = new HashMap();
            for ( Entry<String,Object> column : row.entrySet() )
            {
                mp.put(column.getKey(), column.getValue());
            }
            
            model2.addElement(mp.get("n.cin")+"");
            
        }
        personnelsList.setModel(model2);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        volList = new javax.swing.JComboBox();
        avionList = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        personnelsList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        passagersList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Date:");

        jLabel2.setText("Avion:");

        jLabel3.setText("Vol:");

        jLabel5.setText("Personnels:");

        jLabel4.setText("Passagers:");

        volList.setMinimumSize(new java.awt.Dimension(258, 20));

        personnelsList.setMinimumSize(new java.awt.Dimension(258, 20));
        jScrollPane1.setViewportView(personnelsList);

        jScrollPane2.setViewportView(passagersList);

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

        jLabel6.setText("Quantite:");

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
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)
                        .addComponent(avionList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2)
                        .addComponent(jTextField1)
                        .addComponent(volList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(volList, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(avionList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        List values = passagersList.getSelectedValuesList();
        List values2= personnelsList.getSelectedValuesList();
        ArrayList v3 = new ArrayList();
        String s[] = values.get(0).toString().split(",");
        for(int i=0;i<s.length;i++) s[i]=s[i].replaceAll("\\D+","");
        ArrayList v = new ArrayList(Arrays.asList(s));
        String s2[] = values2.get(0).toString().split(",");
        for(int i=0;i<s2.length;i++) s2[i]=s2[i].replaceAll("\\D+","");
        ArrayList v2 = new ArrayList(Arrays.asList(s2));
        Depart dep = new Depart(jTextField1.getText(), Integer.valueOf(String.valueOf(volList.getSelectedItem())), v2, v, Integer.valueOf(String.valueOf(avionList.getSelectedItem())), Double.valueOf(jTextField2.getText()));
        dep.insertBd();
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(AjouterDepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterDepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterDepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterDepart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterDepart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox avionList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JList passagersList;
    private javax.swing.JList personnelsList;
    private javax.swing.JComboBox volList;
    // End of variables declaration//GEN-END:variables
}
