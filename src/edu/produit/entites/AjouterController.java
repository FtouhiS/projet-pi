

    
    
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.entites;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import edu.produit.model.Produit;
import edu.produit.services.CRUDProduit;
import edu.produit.entites.ListDemande;
import edu.produit.services.Metier;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.P;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author achra
 */
public class AjouterController implements Initializable {

    @FXML
    private Button BT_AjouterProduit;
    @FXML
    private Button BT_ModifierProduit;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfDesc;
    @FXML
    private TextField tfEtat;

    
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }

    @FXML
    private void ajouterProduit(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String nom_produit = tfNom.getText();
        String description = tfDesc.getText();
        String etat = tfEtat.getText();
        if (nom_produit.isEmpty()| description.isEmpty() | etat.isEmpty()){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas envoyer une reclamation avec un champ vide!!");
            alert.show();
        }
        else {
            Produit P = new Produit(nom_produit, description, etat);
            CRUDProduit CP = new CRUDProduit();
            CP.ajouterproduit(P);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton ajoutée Avec succées");
            alert.show();
            tfNom.clear();
            tfDesc.clear();
            tfEtat.clear();
        }
        
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
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    
}
    
    
    
    

