/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roubafika;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Entities.Commande;
import Entities.Echange;
import Entities.Produit;
import Services.CRUDEchange;
import Services.CRUDProduit;
import Services.CRUDUtilisateur;
import Services.ReclamationService;
import Services.ServiceCommande;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author asus
 */
//Afficher les offres d'echage au livreur
public class ListeCommandeAdminController implements Initializable {

    @FXML
    private Node menuComponent;
    
    @FXML
    private TableColumn<?, ?> StatutColumn;
    @FXML
    private Button btnRetour;
    
    private int id_user ;
    
    private TableView<Echange> listEchange;
    @FXML
    private Button btnConsulter;
    private TableColumn<?, ?> LieuColumn2;
    @FXML
    private Label TitreEchange;
    @FXML
    private TableColumn<?, ?> AdresseColumn;
    @FXML
    private TableColumn<?, ?> TelephoneColumn;
    @FXML
    private TableColumn<?, ?> SommeColumn;
    @FXML
    private TableView<Commande> listCommande;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PopulateTable();
        
    }
    public void initData(int idUser) throws SQLException {
        //l'utilisateur veut acheter un produit
        
        this.id_user = idUser ;
        
            
        
    }
    
    public void supprimer() throws IOException {
       
//        int selectedIndex = listProduit.getSelectionModel().getSelectedIndex();
////
//       if (selectedIndex < 0 ) {
//           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//           alert.setTitle("Erreur");
//           alert.setHeaderText("Aucun produit selectionné!");
//           alert.setContentText("Veuiller selectionner un produit pour voir les offres.");
//           Optional<ButtonType> result = alert.showAndWait();
//       } else{
//        try {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation Dialog");
//        alert.setHeaderText("Look, a Confirmation Dialog");
//        alert.setContentText("Are you ok with this?");
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.get() == ButtonType.OK) {
//                CRUDProduit ser = new CRUDProduit();
//                ser.supprimerproduit(listProduit.getSelectionModel().getSelectedItem().getId_produit());
//                PopulateTable();
//
//            } else {
//
//            }
//            throw new SQLException("Sample SQLException");
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }}
    }
            
    

        
    public void PopulateTable(){
        System.out.println("*****************");
        ServiceCommande cr= new ServiceCommande();
        List<Commande> li =cr.afficherCommande();
        System.out.println(li);
        System.out.println("**************");
        ObservableList<Commande> data = FXCollections.observableArrayList(li);
        StatutColumn.setCellValueFactory(
                new PropertyValueFactory<>("statut"));
        AdresseColumn.setCellValueFactory(
                new PropertyValueFactory<>("adresse"));
        TelephoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("numero_tel"));
        SommeColumn.setCellValueFactory(
                new PropertyValueFactory<>("Somme"));
        
        listCommande.setItems(data);
        
        
        
                    
                    
                
    }
            
   

    private void Accepter(ActionEvent event) {
        Echange selectedIndex = listEchange.getSelectionModel().getSelectedItem();
        System.out.println(selectedIndex.getStatut());
        int selected = listEchange.getSelectionModel().getSelectedIndex();

        if (selected < 0 ) {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Erreur");
           alert.setHeaderText("Aucune offre selectionnée!");
           alert.setContentText("Veuiller selectionner une offre à accepter");
           Optional<ButtonType> result = alert.showAndWait();
       } 
        else if (selectedIndex.getStatut().matches("Confirmé")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Erreur");
           alert.setHeaderText("Vous avez déjà accepté cet offre");
           alert.setContentText("Vous ne pouver pas réaccepter une offre");
           alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Offre accepté");
            alert.setContentText("Merci d'accepter cette offre");
            alert.show();
            selectedIndex.setStatut("Confirmé");
            CRUDEchange cr = new CRUDEchange();
            cr.modifierEchange(selectedIndex);
            try {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficherProduit.fxml"));
                Parent root = loader.load();
                AfficherProduitController dcc=loader.getController();
                //user ca=listStaff.getSelectionModel().getSelectedItem();
                dcc.initData(id_user,0,0,0);
                btnRetour.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }}
        
    }

    @FXML
    private void Retour(ActionEvent event) {
        Parent root;
            try {
            root = FXMLLoader.load(getClass().getResource("roubafikaHome.fxml"));
            Scene c=new Scene(root);
            Stage stage=(Stage)btnRetour.getScene().getWindow();
            stage.setScene(c);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @FXML
    private void Consulter(ActionEvent event) {
        Commande selectedIndex = listCommande.getSelectionModel().getSelectedItem();
        int selected = listCommande.getSelectionModel().getSelectedIndex();

        if (selected < 0 ) {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Erreur");
           alert.setHeaderText("Aucune Commande selectionnée!");
           alert.setContentText("Veuiller selectionner une commande à accepter");
           Optional<ButtonType> result = alert.showAndWait();
       } 
        else{
            try {
                System.out.println("//////////////////////////");
                System.out.println(selectedIndex.getIdCommande());
                System.out.println("//////////////////////////");
            FXMLLoader loader=new FXMLLoader(getClass().getResource("PanierAdmin.fxml"));
            Parent root = loader.load();
            PanierAdminController dcc=loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            dcc.initData(selectedIndex.getIdCommande());
            btnRetour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }

    
    }    
    

