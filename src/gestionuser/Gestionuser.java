/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionuser;

import entities.Utilisateur;
import services.CRUDUtilisateur;
import utiles.MaConnexion;

/**
 *
 * @author Soulaima
 */
public class Gestionuser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MaConnexion Connection = MaConnexion.getInstance();
        Utilisateur U = new Utilisateur("omar","abderr",".com",88,"tunis",93456321,"admin");
            
        CRUDUtilisateur crud = new CRUDUtilisateur();
      //crud.ajouterUtilisateur(U);
      //System.out.println(crud.afficherUtilisateur());
       //crud.supprimerUtilisateur(79);
       
       // crud.modifierUtilisateur(U);
        //System.out.println(crud.afficherUtilisateur());

 // TODO code application logic here
    }
    
}
