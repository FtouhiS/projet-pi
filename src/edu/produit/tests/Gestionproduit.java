/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.tests;

import edu.produit.model.Produit;
import edu.produit.services.CRUDProduit;
import edu.produit.utils.MyConnection;
import edu.produit.entites.ListDemande;
import edu.produit.services.CRUDListDemande;

/**
 *
 * @author USER
 */
public class Gestionproduit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnection connexion = MyConnection.getInstance();
     //   Produit p = new Produit("voiture", "utilisée","mauve");
       // CRUDProduit crud = new CRUDProduit();
       //crud.ajouterproduit(p);
       // crud.supprimerproduit(4);
       // crud.modifierproduit(p);
       // crud.afficherpersonnes();
        
        ListDemande d = new ListDemande("omar","abderrahmen","mariem.smaoui@esprit.tn");
       CRUDListDemande c = new CRUDListDemande();
          //      ListDemande p = new ListDemande("MARIEM","abderrahmen","omar.abderrahmen@esprit.tn");

       // c.ajouterListDemande(d);
        c.supprimerListDemande(3);
       // c.modifierListDemande(p);
       // c.afficherListe();
        
        
    }
    
}
