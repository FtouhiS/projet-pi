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
public class InterfaceProduitController implements Initializable {

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
    @FXML
    private TableView<Produit> listProduit;
    @FXML
    private TableColumn<?, ?> NomColumn;
    @FXML
    private TableColumn<?, ?> DescriptionColumn;
    @FXML
    private TableColumn<?, ?> EtatColumn;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnRechercher;
    @FXML
    private TextField recherche;
    @FXML
    private Button btmDemande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CRUDProduit crud = new CRUDProduit();
            ObservableList<Produit> data = FXCollections.observableArrayList(crud.afficherpersonnes());
            System.out.println("///////");
            System.out.println(data);
            System.out.println("///////");
            NomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listProduit.setItems(data);
            throw new SQLException("Sample SQLException");
        } catch (SQLException ex) {
            System.out.println("here");
            Logger.getLogger(InterfaceProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ajouterProduit(ActionEvent event) {
       Parent root;
            try {
           
            root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
            Scene c=new Scene(root);
             Stage stage=(Stage)BT_AjouterProduit.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void modifierProduit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (tfNom.getText().isEmpty()| tfDesc.getText().isEmpty() | tfEtat.getText().isEmpty()){
            alert.setTitle("Reclamation");
            alert.setContentText("Voun ne pouvez pas modifier une reclamation avec un champ vide!!");
            alert.show();
        }
        else{
        int idRec=listProduit.getSelectionModel().getSelectedItem().getId_produit();
        Produit P = new Produit(idRec,tfNom.getText(), tfDesc.getText(),tfEtat.getText());
        CRUDProduit crud = new CRUDProduit();
        crud.modifierproduit(P);
        tfEtat.clear();
        tfNom.clear();
        tfDesc.clear();
        
            ObservableList<Produit> data = FXCollections.observableArrayList(crud.afficherpersonnes());
            NomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listProduit.setItems(data);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton Modifiée Avec succées");
            alert.show();
    }
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int selectedIndex = listProduit.getSelectionModel().getSelectedIndex();

       if (selectedIndex < 0 ) {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Erreur");
           alert.setHeaderText("Aucune reclamation selectionnée!");
           alert.setContentText("Veuiller selectionner une réclamation à supprimer");
           Optional<ButtonType> result = alert.showAndWait();
       } else{
        try {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                CRUDProduit ser = new CRUDProduit();
                ser.supprimerproduit(listProduit.getSelectionModel().getSelectedItem().getId_produit());
                CRUDProduit crud = new CRUDProduit();
                ObservableList<Produit> data = FXCollections.observableArrayList(crud.afficherpersonnes());
            System.out.println("///////");
            System.out.println(data);
            System.out.println("///////");
            NomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
            listProduit.setItems(data);
            alert.setTitle("Reclamation");
            alert.setContentText("Reclamaton supprimée Avec succées");
            alert.show();
            } else {

            }
            throw new SQLException("Sample SQLException");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}
        
    }

    @FXML
    private void rechercher(ActionEvent event) {
        Metier met = new Metier();
        //ServiceUser sca = new ServiceUser();
        System.out.println("/////////////recherche//////////");
        System.out.println(recherche.getText());
        ObservableList<Produit> data = FXCollections.observableArrayList(met.SearchByName(recherche.getText()));
        System.out.println(data);
        NomColumn.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        EtatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
        listProduit.setItems(data);
        
        
    }

    

    @FXML
    private void demande(ActionEvent event) {
        Parent root;
            try {
           
            root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Scene c=new Scene(root);
             Stage stage=(Stage)btmDemande.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    

    
    
    
    
}
    
    
    
    

