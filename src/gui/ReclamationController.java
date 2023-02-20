package gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ReclamationService;
import services.ReponseService;
import utiles.MaConnexion;
import entites.Reclamation;
import entites.Reponse;

/**
 * FXML Controller class
 *
 * @author FGH
 */
public class ReclamationController implements Initializable {

	@FXML
	private Button btnReset;
	@FXML
	private TextField txtId;
	//@FXML
	// private TextField txtDate;
	@FXML
	private TextField txtSujet;
	@FXML

	private  TextArea txtDescription;
	@FXML

	private Button btnSupprimer;
	@FXML
	private Button btnModification;
	@FXML
	private Button btnAfficher;
	@FXML
	private Button btnAjouteReclamation;
	// @FXML
	//private Button btnAfficher;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}    

	/*  @FXML
    private void Reset(ActionEvent event) {
        tfNom.setText("");
        tfPrenom.setText("");
        tfAge.setText("");
    }
	 */
	@FXML
	private void ajouterReclamation(ActionEvent event) {
		LocalDate localDate = LocalDate.now();
		//DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm");
		if ( txtSujet.getText().isEmpty()
				|| txtDescription.getText().isEmpty()) {

			Alert al = new Alert(Alert.AlertType.INFORMATION);
			al.setTitle("Controle de saisie");
			al.setHeaderText("Erreur de saisie !");
			al.setContentText("Les données sont vides !");
			al.show();
		}else{
			//ID est un auto incremente il ne sera pas utulise dans la requete d'ajout
			Reclamation r= new Reclamation (0,Date.valueOf(localDate),txtSujet.getText(),txtDescription.getText());        	
			ReclamationService sp = new ReclamationService();

			try {
				sp.createOne(r);
			} catch (SQLException ex) {
				Alert al = new Alert(Alert.AlertType.ERROR);
				al.setTitle("Erreur");
				al.setHeaderText("Erreur Interne");
				al.setContentText(ex.getMessage());
				al.show();
			}

		}

	}

	/* @FXML
    private void afficherPersons(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherPersonFXML.fxml"));

            Parent root = loader.load();            
            AfficherPersonFXMLController fx = loader.getController();

            ServicePerson sp = new ServicePerson();
            String msg = sp.selectAll().toString();
            fx.setLbAffiche(msg);

            btnAfficher.getScene().setRoot(root);

//            Stage stage = new Stage();
//            stage.setTitle("Afficher Persons");
//            stage.setScene(scene); 
//            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPersonFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	 */

	@FXML
	private void supprimerReclamation(ActionEvent event) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		MaConnexion connexion = MaConnexion.getInstance();


		// on va seulment utuliser l id pour la suppression

		Reclamation r= new Reclamation (5,Date.valueOf(localDate), "","");

		ReclamationService rc= new ReclamationService();	
		Reponse reponse1 =new Reponse (0,"DESCRIPTION");
		ReponseService rs =new ReponseService();

		try {
			rc.deletOne(r);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



	}



	@FXML
	private void afficherReclamations(ActionEvent event) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		MaConnexion connexion = MaConnexion.getInstance();

		Reclamation r2= new Reclamation (0,Date.valueOf(localDate), "sujet","Description");
		Reclamation r3= new Reclamation (0,Date.valueOf(localDate), "Reclamation technique","DEscription1");
		Reclamation r4= new Reclamation (0,Date.valueOf(localDate), "sujet","DEscription");

		ReclamationService rc= new ReclamationService();	
		Reponse reponse1 =new Reponse ("DESCRIPTION");
		ReponseService rs =new ReponseService();



		System.out.println(rc.afficherReclamation());

	}



	@FXML
	private void modifierReclamation(ActionEvent event) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		MaConnexion connexion = MaConnexion.getInstance();

		Reclamation r= new Reclamation (1,Date.valueOf(localDate), "sujet modification","AHMED");


		ReclamationService rc= new ReclamationService();	
		Reponse reponse1 =new Reponse ("DESCRIPTION");
		ReponseService rs =new ReponseService();




		try {
			rc.updateOne(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



}
