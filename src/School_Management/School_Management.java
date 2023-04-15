/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author SAGOR
 */
public class DataBase1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            //StackPane root = new StackPane();
            //root.getChildren().add(btn);
            Scene scene = new Scene(root, 400, 500);

            primaryStage.setTitle("Please Login here");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            //Logger.getLogger(DataBase1.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
