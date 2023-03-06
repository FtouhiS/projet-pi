/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.entites;

import edu.produit.model.Demande;
import edu.produit.model.Produit;
import edu.produit.services.CRUDProduit;
import edu.produit.services.CRUDListDemande;
import edu.produit.services.Metier;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author achra
 */


public class FXMLController implements Initializable {
    

    private Produit ReclamationSelected;
    @FXML
    private Button BT_ModifierProduit;
    private TextField textEtat;
    private TextField textDescription;
    @FXML
    private Button btmAjouterdem;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
     public void initData(int idRec) throws SQLException {
         Metier met = new Metier();
        ReclamationSelected = met.findById(idRec);
        textEtat.setText(ReclamationSelected.getEtat());
        //textNom.setText(listReclamation.getSelectionModel().getSelectedItem().getid_client());
        textDescription.setText(ReclamationSelected.getDescription());
        
    }

    

    @FXML
    private void modifierProduit(ActionEvent event) {
        Parent root;
            try {
           
            root = FXMLLoader.load(getClass().getResource("InterfaceProduit.fxml"));
            Scene c=new Scene(root);
             Stage stage=(Stage)BT_ModifierProduit.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouterDem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String nom_demande = tfNom.getText();
        String prenom = tfPrenom.getText();
        String email = tfEmail.getText();
        if (nom_demande.isEmpty()| prenom.isEmpty() | email.isEmpty()){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas envoyer une demande avec un champ vide!!");
            alert.show();
        }
        else {
            ListDemande P = new ListDemande(nom_demande, prenom, email);
            CRUDListDemande CP = new CRUDListDemande();
            CP.ajouterListeDemande2(P);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton ajoutée Avec succées");
            alert.show();
            tfNom.clear();
            tfPrenom.clear();
            tfEmail.clear();
        }
        
        
    }

   
    
}
