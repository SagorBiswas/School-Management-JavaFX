/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class FirstPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button Adminbtn;
    @FXML private Button Stdbtn;
    @FXML private Button Teabtn;
    @FXML private Button Exitbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   @FXML
    private void adminAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("Admin_Login.fxml")); /* Exception *///Admin_Home
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("Admin Login");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void studentAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("Student_Login.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("Student Login");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void teacherAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("Teacher_Login.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("Teacher Login");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void exitbtnAction(ActionEvent event){
        System.exit(0);
    }
     
}
