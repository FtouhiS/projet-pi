/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import Iservices.IUtilisateur;
import utiles.MaConnexion;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Soulaima
 */
public class CRUDUtilisateur implements IUtilisateur {
 Statement ste;
Connection cnx = MaConnexion.getInstance().getCnx();
        

 @Override
    public void ajouterUtilisateur(Utilisateur U) {
        
    try {
        // Vérifier que l'adresse mail est au format valide
    String mailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    if (!U.getAdresse_mail().matches(mailRegex)) {
        System.out.println("Adresse mail invalide !");
        return;
    }

    

        //les champs sont obligatoires
        if (U.getNom().isEmpty() || U.getPrenom().isEmpty() || U.getAdresse_mail().isEmpty() || U.getmdp() .isEmpty() || U.getAdresse().isEmpty() || U.getNumero_telephone() == 0 || U.getRole().isEmpty()) {
throw new IllegalArgumentException("Veuillez remplir tous les champs obligatoires");
}
        ste = cnx.createStatement();
        String req = "Insert into utilisateur values(0,'"+U.getNom()+"','"+U.getPrenom()+"','"+U.getAdresse_mail()+"','"+U.getmdp()+"','"+U.getAdresse()+"','"+U.getNumero_telephone()+"','"+U.getRole()+"')";
        ste.executeUpdate(req);
        System.out.println("utilisateur ajoutee");
    } catch (SQLException ex) {
            System.out.println("utilisateur non ajoutee!!!!");   
        System.out.println(ex.getMessage());}
    }   
 @Override
    public void modifierUtilisateur(Utilisateur U) {
        try {
            String req = "UPDATE `utilisateur` SET `utilisateur`.`nom` = '" + U.getNom() + "', `utilisateur`.`prenom` = '" + U.getPrenom() + "', `utilisateur`.`adresse mail` = '" + U.getAdresse_mail()+ "', `utilisateur`.`mdp` = '" + U.getmdp() +"', `utilisateur`.`adresse` = '" + U.getAdresse() +"',`utilisateur`.`Numero telephone` = '" + U.getNumero_telephone() +"', `utilisateur`.`roleU` = '" + U.getRole() + "' WHERE `utilisateur`.`IdUser` = " + U.getIdUser() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
 @Override
    public void supprimerUtilisateur (int IdUser){
    try{
        String req ="DELETE FROM `utilisateur` WHERE `utilisateur`.`IdUser`="+IdUser;
           Statement st = cnx.createStatement();
           st.executeUpdate(req);
            System.out.println("utilisateur deleted !");
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
 @Override
   public List<Utilisateur> afficherUtilisateur() {
       List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "Select * from utilisateur";
            Statement st = cnx.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Utilisateur U  = new Utilisateur();
             U.setIdUser(RS.getInt(1));
             U.setNom(RS.getString(2));
             U.setPrenom(RS.getString(3));
             U.setAdresse_mail(RS.getString(4));
             U.setmdp(RS.getString(5));
             U.setAdresse(RS.getString(6));
             U.setNumero_telephone(RS.getInt(7));
             U.setRole(RS.getString(8));
             list.add(U);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

 @Override
    public void ajouterUtilisateur2(Utilisateur U) {
        try {
            String req = "INSERT INTO `utilisateur` (`Nom`, `Prenom`,`Adresse_mail`,`mdp`,`Adresse`,`Numero_telephone`,`roleU`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, U.getNom());
            ps.setString(2, U.getPrenom());
            ps.setString(3, U.getAdresse_mail());
            ps.setString(4, U.getmdp());
            ps.setString(5, U.getAdresse());
            ps.setInt(6, U.getNumero_telephone());
            ps.setString(7, U.getRole());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
        
     
     
     
       
        
       
    }

    @Override
    public ObservableList<Utilisateur> rechercheUser(String nom)
            {
         ObservableList<Utilisateur> list = FXCollections.observableArrayList();

                

        try {
            
            String req = " SELECT * FROM  `utilisateur` WHERE `utilisateur`.`Nom`=?";
           PreparedStatement pst =cnx.prepareStatement(req);
           pst.setString(1, nom);
            ResultSet RS = pst.executeQuery();
          
           while (RS.next()) {
             Utilisateur U = new Utilisateur();
             U.setIdUser(RS.getInt(1));
             U.setNom(RS.getString(2));
             U.setPrenom(RS.getString(3));
             U.setAdresse_mail(RS.getString(4));
             U.setmdp(RS.getString(5));
             U.setAdresse(RS.getString(6));
             U.setNumero_telephone(RS.getInt(7));
             U.setRole(RS.getString(8));
             list.add(U);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(list);
        return list;
      

    }
    
    @Override
    public ObservableList<Utilisateur> rechercheUserbyid( int IdUser)
        {
         ObservableList<Utilisateur> list = FXCollections.observableArrayList();

                

        try {
            
            String req = " SELECT * FROM  `utilisateur` WHERE `utilisateur`.`IdUser`=?";
           PreparedStatement pst =cnx.prepareStatement(req);
           pst.setInt(1, IdUser);
            ResultSet RS = pst.executeQuery();
          
           while (RS.next()) {
             Utilisateur U = new Utilisateur();
             U.setIdUser(RS.getInt(1));
             U.setNom(RS.getString(2));
             U.setPrenom(RS.getString(3));
             U.setAdresse_mail(RS.getString(4));
             U.setmdp(RS.getString(5));
             U.setAdresse(RS.getString(6));
             U.setNumero_telephone(RS.getInt(7));
             U.setRole(RS.getString(8));
             list.add(U);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(list);
        return list;
      

    }
}
  
  
    
    
    
    
    
    
    
    
    
    
    

    

