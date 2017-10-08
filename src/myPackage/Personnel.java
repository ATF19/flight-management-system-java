
package myPackage;

import static myPackage.Main.db;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;


public class Personnel extends Personne {
    private String type;
    public Personnel(String type,int c, String np, String n, String adr, long tel) {
        super(c, np, n, adr, tel);
        this.type = type;
    }
    
    public void insertBd() {
        super.insertBd();
        try (Transaction tx = db.beginTx()) {
            Node vols = db.createNode(Main.Tables.Personnel);
            vols.setProperty("cin",super.getCin());
            vols.setProperty("type",type);
            vols.setProperty("numPassport",super.getNumPassport());
            vols.setProperty("nom",super.getNom());
            vols.setProperty("adresse",super.getAdresse());
            vols.setProperty("telephone",super.getTelephone());
            tx.success();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
