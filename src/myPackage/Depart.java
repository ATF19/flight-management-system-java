/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import java.util.ArrayList;
import myPackage.Main.Relations;
import myPackage.Main.Tables;
import static myPackage.Main.db;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

public class Depart {
    private int numero;
    private static int nbr=0;
    private String date;
    private int vol;
    private ArrayList personnels;
    private ArrayList passagers;
    private int avion;
    private double quantiteAvion;

    public int setNbr() {
        int n=1;
        Result res = db.execute("MATCH (n:Depart) RETURN max(n.numero)");
        String s = res.next().toString();
        s = s.replaceAll("[^0-9]+", "");
        if(s.equals("")) return 1;
        n = Integer.valueOf(s);
        n++;
        return n;
    }
    
    public Depart(String d, int v, ArrayList p, ArrayList pa, int a, double qt) {
        nbr = setNbr();
        numero = nbr;
        date = d;
        vol = v;
        personnels = p;
        passagers = pa;
        avion = a;
        quantiteAvion = qt;
    }
    
    public void insertBd() {
        Result res;
        try (Transaction tx = db.beginTx()) {
            Node depart = db.createNode(Main.Tables.Depart);
            depart.setProperty("numero",numero);
            depart.setProperty("date",date);
            res = db.execute("MATCH (a:Avion), (d:Depart) WHERE a.numero="+avion+" AND d.numero="+numero+" CREATE (a)-[:Affecter]->(d)");
            res = db.execute("MATCH (v:Vol), (d:Depart) WHERE v.numero="+vol+" AND d.numero="+numero+" CREATE (v)-[:Constituer]->(d)");
            for (int i=0; i<passagers.size(); i++) {
                
                res = db.execute("MATCH (p:Passagers), (d:Depart) WHERE p.cin='"+passagers.get(i)+"' AND d.numero="+numero+" CREATE (p)-[:Enregistrer]->(d)");
            }
            for (int i=0; i<personnels.size(); i++) {
                res = db.execute("MATCH (p:Passagers), (d:Depart) WHERE p.cin='"+personnels.get(i)+"' AND d.numero="+numero+" CREATE (p)-[:Enregistrer]->(d)");
            }
            tx.success();
        }
         //res = db.execute("MATCH (d:Depart{date:'"+date+"'}), (p:Passager{cin:'"+passagers.get(0)+"'}) CREATE (p)-[r:Enregistrer]->(d)");
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public ArrayList getPersonnels() {
        return personnels;
    }

    public void setPersonnels(ArrayList personnels) {
        this.personnels = personnels;
    }

    public ArrayList getPassagers() {
        return passagers;
    }

    public void setPassagers(ArrayList passagers) {
        this.passagers = passagers;
    }

    public int getAvion() {
        return avion;
    }

    public void setAvion(int avion) {
        this.avion = avion;
    }

    public double getQuantiteAvion() {
        return quantiteAvion;
    }

    public void setQuantiteAvion(double quantiteAvion) {
        this.quantiteAvion = quantiteAvion;
    }
}
