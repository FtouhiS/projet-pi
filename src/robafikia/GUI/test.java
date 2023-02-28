/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robafikia.GUI;
import robafikia.Robafikia;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import robafikia.GUI.AffCommandeController;
/**
 *
 * @author Mariem
 */
public class test extends Application {
     @Override
    public void start(Stage primaryStage) {
        
        try {
       
            
        
        
         Parent root;
            root = FXMLLoader.load(getClass().getResource("AddCommande.fxml"));

        Scene scene = new Scene(root);
        
        primaryStage.setTitle("SERVICE COMMANDE");
        primaryStage.setScene(scene);
        primaryStage.show();
        
                } catch (IOException ex) {
            Logger.getLogger(Robafikia.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
     public static void main(String[] args) {
        launch(args);
    }
}
