
package myPackage;
import java.util.*;
import java.util.Map.Entry;
import myPackage.Main.Tables;
import static myPackage.Main.db;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.impl.util.StringLogger;
public class Vol {
    private int numero;
    private static int nbr=0;
    private String villeDep;
    private String villeArr;
    private String heureDep;
    private String heureArr;
    private double distance;
    private int frequence;
    
    public int setNbr() {
        int n=1;
        Result res = db.execute("MATCH (n:Vol) RETURN max(n.numero)");
        String s = res.next().toString();
        s = s.replaceAll("[^0-9]+", "");
        if(s.equals("")) return 1;
        n = Integer.valueOf(s);
        n++;
        return n;
    }
    
    public Vol(String vd, String va, String hd, String ha, double dis, int freq) {
        nbr=setNbr();
        numero = nbr;
        villeDep = vd;
        villeArr = va;
        heureDep = hd;
        heureArr = ha;
        distance = dis;
        frequence = freq;
    }
    
    public int insertBd() {
       try (Transaction tx = db.beginTx()) {
            Node vols = db.createNode(Tables.Vol);
            vols.setProperty("numero",numero);
            vols.setProperty("villeDep",villeDep);
            vols.setProperty("villeArr",villeArr);
            vols.setProperty("heureDep",heureDep);
            vols.setProperty("heureArr",heureArr);
            vols.setProperty("distance",distance);
            vols.setProperty("frequence",frequence);
            tx.success();
        }
       return 0;
    }
    
    public int getNumero() {
        return numero;
    }

    public String getVilleDep() {
        return villeDep;
    }

    public void setVilleDep(String villeDep) {
        this.villeDep = villeDep;
    }

    public String getVilleArr() {
        return villeArr;
    }

    public void setVilleArr(String villeArr) {
        this.villeArr = villeArr;
    }

    public String getHeureDep() {
        return heureDep;
    }

    public void setHeureDep(String heureDep) {
        this.heureDep = heureDep;
    }

    public String getHeureArr() {
        return heureArr;
    }

    public void setHeureArr(String heureArr) {
        this.heureArr = heureArr;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
    
}
