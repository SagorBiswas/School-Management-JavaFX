/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

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
public class ProjectMain extends Application {
    
    @Override
    public void start(Stage stage) {
       //Parent root;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));// Admin_Login
            Scene scene = new Scene(root);
           // System.out.println("After Loading");
        
            stage.setScene(scene);
            stage.setTitle("First Page");
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error in loading login page");
            //ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
