
package myPackage;

import static myPackage.Main.db;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Atef
 */
public class Personne {
    private int cin;
    private String numPassport;
    private String nom;
    private String adresse;
    private long telephone;
    
    public Personne(int c, String np, String n, String adr, long tel) {
        cin = c;
        numPassport = np;
        nom = n;
        adresse = adr;
        telephone = tel;
    }
    
    public void insertBd() {
        try (Transaction tx = db.beginTx()) {
            Node vols = db.createNode(Main.Tables.Personne);
            vols.setProperty("cin", getCin());
            vols.setProperty("numPassport", getNumPassport());
            vols.setProperty("nom", getNom());
            vols.setProperty("adresse", getAdresse());
            vols.setProperty("telephone", getTelephone());
            tx.success();
        }
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(String numPassport) {
        this.numPassport = numPassport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }
}
