package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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

import entites.Reponse;

/**
 * FXML Controller class
 *
 * @author FGH
 */
public class ReponseController implements Initializable {

	@FXML
	private Button btnReset;
	@FXML
	private TextField txtIdrep;
	//@FXML
	// private TextField txtDate;

	@FXML
	private  TextArea txtDescriptionrep;
	@FXML

	private Button btnSupprimerReponse;
	@FXML
	private Button btnModificationReponse;
	@FXML
	private Button btnAfficherReponse;
	@FXML
	private Button btnAjouteReponse;
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
	private void ajouterReponse(ActionEvent event) {
		LocalDate localDate = LocalDate.now();
		//DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm");
		if ( txtDescriptionrep.getText().isEmpty()) {

			Alert al = new Alert(Alert.AlertType.INFORMATION);
			al.setTitle("Controle de saisie");
			al.setHeaderText("Erreur de saisie !");
			al.setContentText("Les données sont vides !");
			al.show();
		}else{
			//ID est un auto incremente il ne sera pas utulise dans la requete d'ajout
			Reponse r= new Reponse (0,txtDescriptionrep.getText());        	
			ReponseService sp = new ReponseService();

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


	@FXML
	private void supprimerReclamation(ActionEvent event) {
		// TODO Auto-generated method stub
		// on va seulment utuliser l id pour la suppression

		Reponse r= new Reponse (1,"");
		Reponse reponse1 =new Reponse ("DESCRIPTION");
		ReponseService rs =new ReponseService();




		try {
			rs.deletOne(r);
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



		Reponse reponse1 =new Reponse (0,"DESCRIPTION");
		ReponseService rs =new ReponseService();



		System.out.println(rs.afficherReponse());

	}



	@FXML
	private void modifierReclamation(ActionEvent event) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		MaConnexion connexion = MaConnexion.getInstance();

		Reponse reponse1 =new Reponse (0,"DESCRIPTION");
		ReponseService rs =new ReponseService();




		try {
			rs.updateOne(reponse1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



}
