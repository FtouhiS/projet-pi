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
import Entities.Demande;
import Entities.Service;
import Entities.Service.Categorie;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author moham
 */
public class MyDemande {
    private PreparedStatement pst;
    private Statement ste ;
    private Connection connection;
    private ResultSet rs;
    
    public MyDemande() {
          connection=DataSource.getInstance().getConnection();
    }
    
    public List<Demande> afficherDemande() throws SQLException {
    List<Demande> listeDemande = new ArrayList<>();
    String requete = "SELECT * FROM Demande";
    Statement st;
    ResultSet rs;
    try {
        
        ste = connection.createStatement();
        rs = ste.executeQuery(requete);
        while (rs.next()) {
            Demande demande = new Demande();
            demande.setId(rs.getInt("id"));
            demande.setNom_demandeur(rs.getString("nom_demandeur"));
            demande.setPrenom_demandeur(rs.getString("prenom_demandeur"));
            demande.setEmail_demandeur(rs.getString("email_demandeur"));
            demande.setDate_demande(rs.getString("date_demande"));
            demande.setId_service(rs.getInt("id_service"));
            listeDemande.add(demande);
        }
    } catch (SQLException ex) {
        Logger.getLogger(MyDemande.class.getName()).log(Level.SEVERE, null, ex);
    } 
       return listeDemande;

    }



    
    public void ajouterDemande(Demande d) throws SQLException {
    String requete = "INSERT INTO Demande (nom_demandeur, prenom_demandeur, email_demandeur, date_demande, id_service) VALUES (?,?,?,?,?)";
    try {
        connection = DataSource.getInstance().getConnection();
        pst = connection.prepareStatement(requete);
        pst.setString(1, d.getNom_demandeur());
        pst.setString(2, d.getPrenom_demandeur());
        pst.setString(3, d.getEmail_demandeur());
        pst.setString(4, d.getDate_demande());
        pst.setInt(5, d.getId_service());
        pst.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MyDemande.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        pst.close();
        connection.close();
    }
}

}
