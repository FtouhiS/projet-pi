/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roubafika;

import Entities.Demande;
import Entities.Service;
import Entities.Session;
import Entities.Utilisateur;
import Services.MyDemande;
import Services.MyService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FrontMesServiceController implements Initializable {

    @FXML
    private VBox cardsContainer;

    private MyService cs = new MyService();
    @FXML
    private Button listeService;
    @FXML
    private Button addService;
    @FXML
    private Button mesServices;
    private Stage ajouterStage;
    @FXML
    private Node menuComponent;
    @FXML
    private Button ServicesD;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       


        ObservableList<Service> allCards = cs.ServiceByUser(Session.getCurrentUser().getIdUser());
        int numCards = allCards.size();
        int cardsPerRow = 3;

        for (int i = 0; i < numCards; i += cardsPerRow) {
            HBox hbox = new HBox();
            hbox.setSpacing(70);
            hbox.setPadding(new Insets(30));
            hbox.getStyleClass().add("card-row");

            int endIndex = Math.min(i + cardsPerRow, numCards);
            List<Service> rowCards = allCards.subList(i, endIndex);

            for (Service c : rowCards) {
                BorderPane cardPane = new BorderPane();
                cardPane.getStyleClass().add("card-pane");

                VBox vb = new VBox();
                VBox vbempty = new VBox();
                vbempty.setPrefHeight(20);
                vb.setSpacing(10);
                vb.getStyleClass().add("card-container");
                Label titleLabel = new Label(c.getTitre());
                titleLabel.getStyleClass().add("card-title");
                Label categorieLabel = new Label(c.getCategorie().toString());
                categorieLabel.getStyleClass().add("card-categorie");

                Label descText = new Label(c.getDescription());
                descText.getStyleClass().add("card-desc");
                descText.setWrapText(true);
                descText.setMaxWidth(280);
                vb.getChildren().addAll(titleLabel, categorieLabel, descText);
                vb.prefWidthProperty().bind(hbox.widthProperty().divide(cardsPerRow).subtract(70));
                cardPane.setTop(vb);
                cardPane.setCenter(vbempty);
                 Button SupprimerBtn = new Button("Supprimer");
                SupprimerBtn.getStyleClass().add("card-button-supprimer");
                SupprimerBtn.setOnAction(event -> {
                  cs.deleteService(c.getTitre());
                  allCards.remove(c);
                });
                cardPane.setBottom(SupprimerBtn);
                vb.setMargin(SupprimerBtn, new Insets(10, 0, 0, 0));
                

                hbox.getChildren().add(cardPane);
            }

            cardsContainer.getChildren().add(hbox);
        }
        addService.setOnAction(event -> {
            try {
                Parent Liste = FXMLLoader.load(getClass().getResource("frontAddService.fxml"));

                Scene si = new Scene(Liste);
                si.getStylesheets().add(getClass().getResource("card.css").toExternalForm());
                Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
                st.setScene(si);
                st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        
        listeService.setOnAction(event -> {
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
        ServicesD.setOnAction(event -> {
            try {
                Parent Liste = FXMLLoader.load(getClass().getResource("frontServiceDemande.fxml"));

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

    private void loadFrontService() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("frontService.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) addService.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
