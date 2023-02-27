/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionuser;

import entities.Role;
import entities.Utilisateur;
import services.CRUDRole;
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
       Utilisateur U= new Utilisateur(96,"ft","mar","sou@email.com","45826636","test",93666777,"user");
//Role R =new Role("user");
            
        //CRUDUtilisateur crud = new CRUDUtilisateur();
       // CRUDRole crud = new CRUDRole();
    //crud.ajouterRole(R);
    //crud.rechercheUserbyid(93);
 
 //System.out.println(crud.afficherRole());
  // crud.supprimerUtilisateur(92);
   
   //System.out.println(crud.afficherUtilisateur());
   

    
   //crud.modifierUtilisateur(U);
   //System.out.println(crud.afficherUtilisateur());

 // TODO code application logic here
    }
    
}
