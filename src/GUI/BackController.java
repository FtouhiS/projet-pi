/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class BackController implements Initializable {

    @FXML
    private AnchorPane bord;
    @FXML
    private Label nomuser;
    @FXML
    private VBox vbox1;
    @FXML
    private Button butnmod;
    @FXML
    private Button supp;
    @FXML
    private Button retour;
    @FXML
    private Button ref;
    @FXML
    private TextField Lieuu;
    @FXML
    private TextField Adressee;
    @FXML
    private TextField NumTel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Modifier(ActionEvent event) {
    }

    @FXML
    private void Supprimer(ActionEvent event) {
    }

    @FXML
    private void Retour(ActionEvent event) {
    }

    @FXML
    private void Refresh(ActionEvent event) {
    }
    
}
