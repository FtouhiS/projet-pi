/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package robafikia.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
import robafikia.utils.MaConnexion;
import robafikia.entities.Commande;
import robafikia.services.ServiceCommande;
import robafikia.GUI.AddCommandeController;
import robafikia.Robafikia;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class AffCommandeController implements Initializable {

    private TableView<Commande> tab;
       

    private TableColumn<Commande, String> Lieu;

    private TableColumn<Commande, String> Adresse;
    
    
    private TableColumn<Commande, String> Numero;
    
     @FXML
    private Button retour;
     
          @FXML
    private Button supp;

    private TextField id;
    
    @FXML
    private Button ref;

     @FXML
    private TextField Lieuu;

    

    @FXML
    private TextField Adressee;

    @FXML
    private TextField NumTel;

    
    @FXML
    private Button butnmod;
    private TableColumn<?, ?> idCOM;
    private Button autre;
   
     @FXML
    private VBox vbox1;
    ServiceCommande sc= new ServiceCommande();
    Commande c;
    @FXML
    private AnchorPane bord;
    @FXML
    private Label nomuser;

    public void table(){
     
        idCOM.setCellValueFactory(new PropertyValueFactory <>("idCommande"));
        Lieu.setCellValueFactory( new PropertyValueFactory<>("Lieu"));
        Adresse.setCellValueFactory(new PropertyValueFactory <>("Adresse"));
        Numero.setCellValueFactory(new PropertyValueFactory <>("Numero"));
        

        tab.setItems(RecupBase()); 

}
   
    
    @FXML
    public void Supprimer(ActionEvent event){
    
     int selectedIndex = tab.getSelectionModel().getSelectedIndex();

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
                ServiceCommande ser = new ServiceCommande();
                ser.supprimerOne(tab.getSelectionModel().getSelectedItem().getId());
                ServiceCommande crud = new ServiceCommande();
                ObservableList<Commande> data = FXCollections.observableArrayList(crud.selectAll());
            System.out.println("///////");
            System.out.println(data);
            System.out.println("///////");
            Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            Numero.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));
            tab.setItems(data);
            alert.setTitle("Commande");
            alert.setContentText("Commande supprimée Avec succées");
            alert.show();
            } else {

            }
            throw new SQLException("Sample SQLException");
        } catch (SQLException ex) {
            System.out.println(ex);
        }}
  
    }
    
     @FXML
    public void Refresh(ActionEvent event){
    
   table();
  
    }
    public void supp(int id){
    
      java.sql.Connection cnx;
     cnx = MaConnexion.getInstance().getCnx();
          try {
            String sql = "DELETE FROM commande WHERE `idCommande` = '" +id+ "' " ;
            
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);
 
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    
    @FXML
private void Retour(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCommande.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.setTitle("TitreDeVotreFenêtre");
    stage.show();
}
  //affichter  
    public static ObservableList<Commande> RecupBase(){
             
    ObservableList<Commande> list = FXCollections.observableArrayList();
    
       java.sql.Connection cnx;
     cnx = MaConnexion.getInstance().getCnx();
          String sql = "select *from commande";
    try {
       
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);

    ResultSet R = st.executeQuery();
    while (R.next()){
      Commande r =new Commande();
     //r.setId(R.getString(1));
           r.setId(R.getInt(1));
           

       r.setLieu(R.getString(2));
     r.setAdresse(R.getString(3));
     
     r.setNumero_tel(R.getString(4));
     
    
     
      list.add(r);
    }
    }catch (SQLException ex){
    ex.getMessage(); 
    } 
    return list;
    }
    

  public void onEdit() {

        java.sql.Connection cnx;
        cnx = MaConnexion.getInstance().getCnx();

        if (tab.getSelectionModel().getSelectedItem() != null) {
            Commande commande = tab.getSelectionModel().getSelectedItem();
//            String n = Prixx.getText();
//int p = Integer.valueOf(n);

            
         
            Lieu.setText(commande.getLieu());
            Adresse.setText(commande.getAdresse());
            Numero.setText(commande.getNumero_tel());

        
            




}}
  
  
  
  @FXML
void Modifier(ActionEvent event) {
    String t = Lieuu.getText();
    String ivd = Adressee.getText();
    String l = NumTel.getText();
    

    String sql = "UPDATE commande SET lieu = '"+ t +"', adresse = '"+ ivd +"', numero_tel = '"+ l +"' WHERE idCommande = '"+ id +"'" ;
    java.sql.Connection cnx;
    cnx = MaConnexion.getInstance().getCnx();
    try {
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);
        st.executeUpdate();
        table();
        JOptionPane.showMessageDialog(null,"Le fichier a été modifié");
    } catch (SQLException ex) {
        ex.getMessage();
    }
}

  
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        
//        table();
//        // lhjett ily nhbhom yadhhroo au debut de runn d'applicat  TODO
//        //selection
//        tab.setOnMouseClicked((MouseEvent event) -> {
//    if (event.getClickCount() > 0) {
//        onEdit();
//        
//    }
//});
        //idCOM.setVisible(false);
        /*
        try {
            ServiceCommande crud = new ServiceCommande();
            ObservableList<Commande> data = FXCollections.observableArrayList(crud.selectAll());
            System.out.println("///////");
            System.out.println(data);
            System.out.println("///////");
           // idCOM.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
            Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            Numero.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));
            tab.setItems(data);
            //throw new SQLException("Sample SQLException");
        } catch (SQLException ex) {
            System.out.println("here");
            Logger.getLogger(AffCommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
         try {
        List<Commande> commande = sc.selectAll();// remplace 1 par client.id
                   /* ServiceCommande crud = new ServiceCommande();
                    ObservableList<Commande> commande = FXCollections.observableArrayList(crud.selectAll());*/

        System.out.println(commande);
          for (Commande c : commande)
          {
              
          
        
        Pane paneback = new Pane();
paneback.setPrefSize(800.0, 61.0);
paneback.setStyle("-fx-background-color: #708C98;");
 
Label label1 = new Label(c.getId()+"");
label1.setTextFill(Paint.valueOf("#f8f8f8"));
label1.setFont(Font.font("System Bold", 18.0));
label1.setLayoutX(30.0);
label1.setLayoutY(15.0);
idCOM.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
 /*
Label label2 = new Label(c.getCl().getId_user()+"");
label2.setTextFill(Paint.valueOf("#f8f8f8"));
label2.setFont(Font.font("System Bold", 18.0));
label2.setLayoutX(89.0);
label2.setLayoutY(15.0);
 */
Label label3 = new Label(c.getLieu()+"");
label3.setTextFill(Paint.valueOf("#f8f8f8"));
label3.setFont(Font.font("System Bold", 18.0));
label3.setLayoutX(185.0);
label3.setLayoutY(15.0);
 Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));

 
 Label label5 = new Label(c.getAdresse());
label5.setTextFill(Paint.valueOf("#f8f8f8"));
label5.setFont(Font.font("System Bold", 18.0));
label5.setLayoutX(416.0);
label5.setLayoutY(15.0);
 Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

 
Label label4 = new Label(c.getNumero_tel());
label4.setTextFill(Paint.valueOf("#f8f8f8"));
label4.setFont(Font.font("System Bold", 18.0));
label4.setLayoutX(296.0);
label4.setLayoutY(15.0);
 Numero.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));

 
        
        
    }
         }
     catch (SQLException ex) {
            System.out.println("here");
            Logger.getLogger(AffCommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
    private void page(ActionEvent event) {
        Parent root;
                try {

                root = FXMLLoader.load(getClass().getResource("AddCommande.fxml"));
                Scene c=new Scene(root);
                 Stage stage=(Stage)autre.getScene().getWindow();
                stage.setScene(c);
            } catch (IOException ex) {
                Logger.getLogger(Robafikia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
        
}