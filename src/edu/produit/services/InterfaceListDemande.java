/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.services;
import edu.produit.entites.ListDemande;
import java.util.List;
/**
 *
 * @author abder
 */
public interface InterfaceListDemande {
      public void ajouterListDemande(ListDemande p);
    public void ajouterListeDemande2 (ListDemande p);
    public void modifierListDemande(ListDemande p);
    public void supprimerListDemande(int id_produit);
    public List<ListDemande> afficherListe();
}
