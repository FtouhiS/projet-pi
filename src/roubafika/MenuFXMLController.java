/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roubafika;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class MenuFXMLController implements Initializable {

    @FXML
    private VBox menuBar;
    @FXML
    private HBox servicesModule;
    @FXML
    private Button servicesButton;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logo.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("roubafikaHome.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        servicesButton.setOnAction(event -> {
            try {
                Parent Liste = FXMLLoader.load(getClass().getResource("frontService.fxml"));

                Scene si = new Scene(Liste);
                si.getStylesheets().add(getClass().getResource("card.css").toExternalForm());
                Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
                st.setScene(si);
                st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
    }    
    
}
