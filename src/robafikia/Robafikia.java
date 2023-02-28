/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package robafikia;

/**
 *
 * @author Mariem
 */
import robafikia.entities.Commande;
import robafikia.services.ServiceCommande;
import robafikia.services.ServiceLigneCommande;
import robafikia.utils.MaConnexion;
import robafikia.entities.LigneCommande;
import java.sql.SQLException;
public class Robafikia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaConnexion cn1 = MaConnexion.getInstance();
         System.out.println(cn1.hashCode());
      // Commande com = new Commande("tunis","","20230254");
      Commande com = new Commande(1,"tunis","ariana soghra","20260377");
       ServiceCommande sp = new ServiceCommande();
     // LigneCommande sp = new LigneCommande(-5);
        //ServiceLigneCommande sp = new ServiceLigneCommande();
          try {
             // sp.createOne(com);
          //  sc.createOne(cc);
         //  sc.supprimerOne(1);
           sp.updateOne(com);
           // sp.createOne(com);
             //sp.createOne(p);
             //lazm f update id mwjoud //
         //  sp.updateOne(com);
         //sc.deletOne(cc);
            // sv.createOne(pt);
            // sp.updateOne(p);
           
           // System.out.println(sp.selectAll());
           System.out.println(sp.selectAll());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
