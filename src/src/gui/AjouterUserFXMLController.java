/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

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
import services.CRUDUtilisateur;
import entities.Utilisateur;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Soulaima
 */
public class AjouterUserFXMLController implements Initializable {

    @FXML
    private AnchorPane btnReset;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfAdresse_mail;
    @FXML
    private TextField tfmdp;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfnumero;
    @FXML
    private Button btnsinscrire;
    @FXML
    private TextField tfrole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Reset(ActionEvent event) {
        tfNom.setText("");
        tfPrenom.setText("");
        tfAdresse_mail.setText("");
        tfmdp.setText("");
        tfAdresse.setText(""); 
        tfnumero.setText("");
        tfrole.setText("");
        
        
    }

    @FXML
    private void ajouterUtlisateur(ActionEvent event) {
        if(tfNom.getText().isEmpty()
           || tfPrenom.getText().isEmpty()
           || tfAdresse_mail.getText().isEmpty()
           || tfmdp.getText().isEmpty()
           || tfAdresse.getText().isEmpty()       
           || tfnumero.getText().isEmpty()
           || tfrole.getText().isEmpty()
                
                )
            

            
           
    
        {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Controle de saisie");
            al.setHeaderText("Erreur de saisie !");
            al.setContentText("Les données sont vides !");
            al.show();
        
         }else{
             Utilisateur U  = new Utilisateur(tfNom.getText()
                    , tfPrenom.getText(),tfAdresse_mail.getText(),
                     tfmdp.getText(),tfAdresse.getText(), Integer.parseInt(tfnumero.getText()),tfrole.getText() );
                 
            
             CRUDUtilisateur crud = new CRUDUtilisateur();
            
            try {
            crud.ajouterUtilisateur(U);
            } 
           catch (Exception ex) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("Erreur");
                al.setHeaderText("Erreur Interne");
                al.setContentText(ex.getMessage());
                al.show();
            }
            
        }
            
    }

    

   

  

    
    }


    
    

