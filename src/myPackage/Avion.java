/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import myPackage.Main.Tables;
import static myPackage.Main.db;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Atef
 */
public class Avion {

    
    private int numero;
    private static int nbr=0;
    private String type;
    private int capacite;
    
    public int setNbr() {
        int n=1;
        Result res = db.execute("MATCH (n:Avion) RETURN max(n.numero)");
        String s = res.next().toString();
        s = s.replaceAll("[^0-9]+", "");
        if(s.equals("")) return 1;
        n = Integer.valueOf(s);
        n++;
        return n;
    }
    
    public Avion(String t, int c) {
        nbr=setNbr();
        numero=nbr;
        type = t;
        capacite = c;
    }
    
    public int insertBd() {
       try (Transaction tx = db.beginTx()) {
            Node vols = db.createNode(Tables.Avion);
            vols.setProperty("numero",numero);
            vols.setProperty("type",type);
            vols.setProperty("capacite",capacite);
            tx.success();
        }
       return 0;
    }
    
    public static int getNbr() {
        return nbr;
    }

    public static void setNbr(int aNbr) {
        nbr = aNbr;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
