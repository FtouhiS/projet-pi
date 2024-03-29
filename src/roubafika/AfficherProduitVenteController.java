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
import Entities.Produit;
import Entities.Session;
import Services.CRUDProduit;
import Services.CRUDUtilisateur;
import Services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author asus
 */
//Afficher les produits
public class AfficherProduitVenteController implements Initializable {

    @FXML
    private TableView<Produit> listProduit;
    @FXML
    private TableColumn<Produit, String> NomColumn;
    @FXML
    private TableColumn<Produit, String> DescriptionColumn;
    private TableColumn<Produit, String> EtatColumn;
    @FXML
    private Button btnRechercher;
    @FXML
    private TextField recherche;
    @FXML
    private TableColumn<?, ?> CategorieColumn;
    @FXML
    private ImageView ImageProduit;
    @FXML
    private TableColumn<?, ?> PrixColumn;
    @FXML
    private TextArea textDescription;
    TableView.TableViewSelectionModel<Produit> selectionModel;
    private Label TitreMesProduits;
    @FXML
    private Label TitreProduits;
    private Button btnOffre;
    private Button btnAction;
    private int id_user;
    private ArrayList<Integer> panier;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnPanier;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initData(int idUser, ArrayList<Integer> panier) throws SQLException {
        //l'utilisateur veut acheter un produit
        this.id_user = idUser;
        this.panier = panier;
        PopulateTable();

    }

    public void supprimer() throws IOException {

        int selectedIndex = listProduit.getSelectionModel().getSelectedIndex();
//
        if (selectedIndex < 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Aucun produit selectionné!");
            alert.setContentText("Veuiller selectionner un produit pour voir les offres.");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    CRUDProduit ser = new CRUDProduit();
                    ser.supprimerproduit(listProduit.getSelectionModel().getSelectedItem().getId_produit());
                    PopulateTable();

                } else {

                }
                throw new SQLException("Sample SQLException");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    public void PopulateTable() {
        CRUDProduit cr = new CRUDProduit();
        textDescription.setVisible(false);
        List<Produit> li = cr.afficherproduitPrix();
        ObservableList<Produit> data = FXCollections.observableArrayList(li);
        NomColumn.setCellValueFactory(
                new PropertyValueFactory<>("nom_produit"));
        CategorieColumn.setCellValueFactory(
                new PropertyValueFactory<>("Categorie"));
        DescriptionColumn.setCellValueFactory(
                new PropertyValueFactory<>("Description"));
        PrixColumn.setCellValueFactory(
                new PropertyValueFactory<>("Prix"));
        listProduit.setItems(data);

        listProduit.setRowFactory(tv -> {
            TableRow<Produit> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Produit rowData = row.getItem();
                    Blob blob = rowData.getImage();
                    InputStream inputStream;
                    try {
                        inputStream = blob.getBinaryStream();
                        Image image = new Image(inputStream);
                        ImageProduit.setImage(image);
                        textDescription.setVisible(true);
                        textDescription.setText(rowData.getDescription());
                    } catch (SQLException ex) {
                        Logger.getLogger(AfficherProduitVenteController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // Effectuer l'action souhaitée avec la ligne sélectionnée
                    // Par exemple :
                    // Effectuer l'action souhaitée avec la ligne sélectionnée
                    // Par exemple :
                    // Effectuer l'action souhaitée avec la ligne sélectionnée
                    // Par exemple :
                    // Effectuer l'action souhaitée avec la ligne sélectionnée
                    // Par exemple :

                }
            });
            return row;
        });

    }

    public void Acheter() throws ParseException {
        System.err.println("Acheter Un produit pleaaase");
    }

    @FXML
    public void rechercher(ActionEvent event) throws IOException {
       PopulateTableByName();


    }
public void PopulateTableByName() {
        CRUDProduit cr = new CRUDProduit();
        textDescription.setVisible(false);
        List<Produit> li = cr.afficherproduit();
        ObservableList<Produit> data = FXCollections.observableArrayList(cr.afficherproduitParNom(recherche.getText()));
        NomColumn.setCellValueFactory(
                new PropertyValueFactory<>("nom_produit"));
        CategorieColumn.setCellValueFactory(
                new PropertyValueFactory<>("Categorie"));
        DescriptionColumn.setCellValueFactory(
                new PropertyValueFactory<>("Description"));
        PrixColumn.setCellValueFactory(
                new PropertyValueFactory<>("Prix"));
        listProduit.setItems(data);

        listProduit.setRowFactory(tv -> {
            TableRow<Produit> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Produit rowData = row.getItem();
                    Blob blob = rowData.getImage();
                    InputStream inputStream;
                    try {
                        inputStream = blob.getBinaryStream();
                        Image image = new Image(inputStream);
                        ImageProduit.setImage(image);
                        textDescription.setVisible(true);
                        textDescription.setText(rowData.getDescription());
                    } catch (SQLException ex) {
                        Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // Effectuer l'action souhaitée avec la ligne sélectionnée
                    // Par exemple :

                }
            });
            return row;
        });

    }
    private void Ajouter_au_panier() {

    }

    @FXML
    private void Ajouter(ActionEvent event) {
        int idpr = listProduit.getSelectionModel().getSelectedItem().getId_produit();
        if (this.panier.contains(idpr)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Produit déjà ajouté à votre panier");
            alert.show();
        } else if (listProduit.getSelectionModel().getSelectedItem().getId_user() == this.id_user) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Vous ne pouvez pas séléctionner votre produit");
            alert.show();
        } else {
            this.panier.add(idpr);
        }
        System.out.println(panier);
    }

    @FXML
    private void Panier(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
            Parent root = loader.load();
            PanierController dcc = loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            dcc.initData(id_user, this.panier);
            btnPanier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void AcheterProduits(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficherProduitVente.fxml"));
            Parent root = loader.load();
            AfficherProduitVenteController dcc=loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            int idUser=14;
            ArrayList<Integer> panier = new ArrayList<Integer>();
            dcc.initData(idUser,panier);
            btnPanier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void MesProduits(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficherProduit.fxml"));
            Parent root = loader.load();
            AfficherProduitController dcc=loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
           
            dcc.initData(Session.getCurrentUser().getIdUser(),0,0,0);
            btnPanier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EchangerProduits(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficherProduit.fxml"));
            Parent root = loader.load();
            AfficherProduitController dcc=loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            
            dcc.initData(Session.getCurrentUser().getIdUser(),1,0,0);
            btnPanier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void AjouterProduit(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AjouterProduit.fxml"));
            Parent root = loader.load();
            AjouterProduitController dcc=loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            int idUser=14;
            dcc.initData(Session.getCurrentUser().getIdUser());
            btnPanier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @FXML
    private void stats(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StatProduit.fxml"));
            Parent root = loader.load();
            StatProduitController dcc = loader.getController();
            //user ca=listStaff.getSelectionModel().getSelectedItem();
            ArrayList<Integer> panier = new ArrayList<Integer>();
            try {
                dcc.initData(Session.getCurrentUser().getIdUser());
            } catch (ParseException ex) {
                Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            listProduit.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReponseReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
