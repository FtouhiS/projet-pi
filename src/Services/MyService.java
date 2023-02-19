/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entities.Service;
import Entities.Service.Categorie;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author moham
 */
public class MyService {
    private PreparedStatement pst;
    private Statement ste ;
    private Connection connection;
    private ResultSet rs;
    
    
    
     public MyService() {
         connection=DataSource.getInstance().getConnection();
     }
    public ObservableList<Service> affichage(){
     ObservableList<Service> list = FXCollections.observableArrayList();
     String requete="select * from service";
     Statement st;
     ResultSet rs;
   
        try {
            ste = connection.createStatement();
           rs= ste.executeQuery(requete);
            while (rs.next()) { 
                String categorieStr = rs.getString("categorie");
                Categorie categorie = Categorie.valueOf(categorieStr);
                 list.add(new Service( rs.getString("titre"),rs.getString("description"), rs.getString("date_annonce"), rs.getString("adresse"), categorie));              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MyService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public int ajouterService(Service s)  {
    String requeteInsert = "INSERT INTO service ( titre , description , date_annonce, adresse, categorie) VALUES (?,?,?,?,?)";
    try {
        System.out.println("service , "+s);
        pst = connection.prepareStatement(requeteInsert, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1,s.getTitre());
        pst.setString(2,s.getDescription());
        pst.setString(3,s.getDate_annonce());
        pst.setString(4,s.getAdresse());
        pst.setString(5,s.getCategorie().toString());
        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            System.out.println("Service ajouté avec ID : " + id);
            return id;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
}

    
    public boolean deleteService(String id) {
    String requete = "DELETE FROM service WHERE titre= '"+id+"'";
    try {
        ste = connection.createStatement();
        int rowsDeleted = ste.executeUpdate(requete);
        if (rowsDeleted > 0) {
            System.out.println("Service was successfully deleted");
            return true;
        } else {
            System.out.println("Failed to delete the service");
            return false;
        }
    } catch (SQLException ex) {
        Logger.getLogger(MyService.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Failed to delete the service");
        return false;
    }
}
     
    
     public void updateService(Service s, String id) {
    String requete = "UPDATE service SET titre = '"+s.getTitre()+"', description = '"+s.getDescription()+"', date_annonce = '"+s.getDate_annonce()+"', adresse = '"+s.getAdresse()+"', categorie = '"+s.getCategorie()+"' WHERE titre = '" + id + "'";
    try {
        ste = connection.createStatement();
        ste.executeUpdate(requete);
    } catch (SQLException ex) {
        Logger.getLogger(MyService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

   

 
}  


    




     



