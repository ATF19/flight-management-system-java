package myPackage;

import java.util.ArrayList;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Main {
    static GraphDatabaseFactory dbFact = null;
    static GraphDatabaseService db = null;
    
    
    public enum Tables implements Label {
        Personne, Vol, Avion, Depart, Passager, Personnel, Naviguant, NonNaviguant, Pilote, QuantiteAvion;
    }
    public enum Relations implements RelationshipType {
        Enregistrer, AffecterPersonnel, AffecterAvion, Constituer;
    } 
    
    public static void main(String []args) {
        dbFact = new GraphDatabaseFactory();
        db= dbFact.newEmbeddedDatabase("gestionAvionsBD2");
        /*AjouterDepart ad = new AjouterDepart();
        ad.setLocationRelativeTo(null);
        ad.loadTableBD();
        ad.setVisible(true);*/
        
        MainWindow mainFen = new MainWindow();
        mainFen.setLocationRelativeTo(null);
        mainFen.setVisible(true);
            /*Node jNode = db.createNode(Tutorials.JAVAtest);
            Node jNode2 = db.createNode(Tutorials.Test2);
            jNode.setProperty("Id", "5");
            jNode2.setProperty("Id2", "10");11
            Relationship relat = jNode.createRelationshipTo(jNode2, Relations.Relation);
            relat.setProperty("Id", "15");
            tx.success();*/
}
}