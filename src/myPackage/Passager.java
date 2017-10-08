/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import static myPackage.Main.db;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Atef
 */
public class Passager extends Personne {

    public Passager(int c, String np, String n, String adr, long tel) {
        super(c, np, n, adr, tel);
    }
    
    public void insertBd() {
        super.insertBd();
        try (Transaction tx = db.beginTx()) {
            Node vols = db.createNode(Main.Tables.Passager);
            vols.setProperty("cin",super.getCin());
            vols.setProperty("numPassport",super.getNumPassport());
            vols.setProperty("nom",super.getNom());
            vols.setProperty("adresse",super.getAdresse());
            vols.setProperty("telephone",super.getTelephone());
            tx.success();
        }
    }
}
