/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.services;

import edu.produit.entites.ListDemande;
import edu.produit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abder
 */
public class CRUDListDemande implements InterfaceListDemande{
  Statement ste;
    Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public void ajouterListDemande(ListDemande p) {
         try {
        ste = conn.createStatement();
               String req = "Insert into list_demande values(0,'"+p.getNom_d()+"','"+p.getPrenom_d()+"','"+p.getEmail_d()+"')";

        ste.executeUpdate(req);
        System.out.println("list de demande ajouté");
    } catch (SQLException ex) {
            System.out.println("list de demande  non ajouté!!!!");    }
    }

    @Override
    public void ajouterListeDemande2(ListDemande p) {
        try {
            String req = "INSERT INTO `list_demande` (`nom_d`, `prenom_d`,`email_d`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(3, p.getNom_d());
            ps.setString(2, p.getPrenom_d());
            ps.setString(1, p.getEmail_d());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierListDemande(ListDemande p) {
         try {
       String req = "UPDATE `list_demande` SET `nom_d` = '"+ p.getNom_d()+ "',`prenom_d` = '" +p.getPrenom_d()+ "',`email_d`='"+p.getEmail_d()+"' WHERE `list_demande`.`id_demande` = " + p.getId_demande();
    Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("list demande updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerListDemande(int id_demande) {
        try {
            String req = "DELETE FROM `list_demande` WHERE id_demande = " + id_demande ;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("liste de demande est supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ListDemande> afficherListe() {
        List<ListDemande> prod = new ArrayList<ListDemande>();
        try {
        String req = "SELECT * FROM `list_demande`";
        //ResultSet result = ste.executeQuery(req);
        PreparedStatement resultat = conn.prepareStatement(req);
                ResultSet result = resultat.executeQuery();

        while (result.next()) {
            ListDemande resultListDemande = new ListDemande(result.getInt("id_demande"), result.getString("nom_d"),result.getString("prenom_d"),result.getString("email_d"));
            prod.add(resultListDemande);
        }
        System.out.println(prod);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return prod;
    }
    
    
    
 }
    

