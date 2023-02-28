/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roubafika;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author moham
 */
public class card extends Pane {
    private Label titleLabel;
    private ImageView imageView;

    public card(String title, String imageUrl) {
        titleLabel = new Label(title);
        imageView = new ImageView(imageUrl);

        VBox vbox = new VBox(titleLabel, imageView);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #CCCCCC; -fx-border-radius: 5px;");

        getChildren().add(vbox);
    }

    public static void addCard(String title, String imageUrl, Pane parent) {
        card c = new card(title, imageUrl);
        parent.getChildren().add(c);
    }
}