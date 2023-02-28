/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package robafikia.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import robafikia.Robafikia;
import robafikia.utils.MaConnexion;

import robafikia.entities.Commande;
import robafikia.services.ServiceCommande;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class AddCommandeController implements Initializable {

    /**
     * Initializes the controller class.
     */
      private Connection cnx;
    private Button modifier;
    @FXML
    private Button retour;
    @FXML
    private AnchorPane bord;
    @FXML
    private Label nomuser;
    @FXML
    private VBox vbox1;
    @FXML
    private Button butnmod;
    @FXML
      private Button butAjouter;
    @FXML
    private Button supp;
    @FXML
    private Button ref;
    @FXML
    private TextField Lieuu;
    @FXML
    private TextField Adressee;
    @FXML
    private TextField NumTel;

    public AddCommandeController(){
        cnx = MaConnexion.getInstance().getCnx();
    }
    
      

    private ComboBox<String> Lieu;

    private TextField Adresse;

    private TextField Numero;

    
   
    @FXML 
    private void Retour(ActionEvent event) throws IOException {
    Parent root;
                try {

                root = FXMLLoader.load(getClass().getResource("AffCommande.fxml"));
                Scene c=new Scene(root);
                 Stage stage=(Stage)retour.getScene().getWindow();
                stage.setScene(c);
            } catch (IOException ex) {
                Logger.getLogger(Robafikia.class.getName()).log(Level.SEVERE, null, ex);
        }
}


    
    
     //cliiiccckkkk
        private void AddCommande(ActionEvent event){
           
           EnrejistreBase();
        Lieu.setValue(null);
           Adresse.clear();
           
           Numero.clear();
           
            
       
       
       
       }
    
    
  
    private void EnrejistreBase(){
    java.sql.Connection cnx;
    cnx = MaConnexion.getInstance().getCnx();
    

    if (Lieu.getValue() == null
           
            || Adresse.getText().isEmpty()
            || Numero.getText().isEmpty())
        
    {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Controle de saisie");
            al.setHeaderText("Erreur de saisie !");
            al.setContentText("Les données sont vides !");
            al.show();
}
    else {
    try {
        String sql = "INSERT INTO commande (`lieu`, `adresse`, `numero_tel`) VALUES (?,?,?)";

        
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);
        st.setString(1, Lieu.getValue());
        st.setString(2, Adresse.getText());
        st.setString(3, Numero.getText());
        
        
        st.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Erreur : " + ex.getMessage());
    }
}
    }
      

    @Override
    public void initialize(URL location, ResourceBundle resources) {
  List<String> gouvernorats = Arrays.asList(
            "Ariana", "Béja", "Ben Arous", "Bizerte", "Gabès",
            "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kébili",
            "La Manouba", "Le Kef", "Mahdia", "Médenine", "Monastir",
            "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse",
            "Tataouine", "Tozeur", "Tunis", "Zaghouan"
        );
           
        Lieu.setItems(FXCollections.observableArrayList(gouvernorats));
    }

    private void redirectToPage(ActionEvent event) {
         Parent root;
                try {

                root = FXMLLoader.load(getClass().getResource("AffCommande.fxml"));
                Scene c=new Scene(root);
                 Stage stage=(Stage)modifier.getScene().getWindow();
                stage.setScene(c);
            } catch (IOException ex) {
                Logger.getLogger(Robafikia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
 }
    

