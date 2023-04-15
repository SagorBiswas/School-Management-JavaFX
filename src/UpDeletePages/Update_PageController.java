/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpDeletePages;

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
public class Update_PageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button stdbtn;
    @FXML private Button teabtn;
    @FXML private Button empbtn;
    @FXML private Button evntbtn;
    @FXML private Button stdmrksbtn;
    @FXML private Button backbtn;
    @FXML private Button signoutbtn;
    @FXML private Button extbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void stdbtnAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/UpDeletePages/Student_Update.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setTitle("Student Update Page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    @FXML
    private void teabtnAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/UpDeletePages/Teacher_Update.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setTitle("Student Update Page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    @FXML
    private void empbtnAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/UpDeletePages/Employee_Update.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setTitle("Student Update Page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    @FXML
    private void evntbtnAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/UpDeletePages/Event_Update.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setTitle("Student Update Page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void stdmrksbtnAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/UpDeletePages/Student_Update.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setTitle("Student Update Page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    @FXML
    void signoutbuttonAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/ProjectTables/Admin_Login.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin Login");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
   @FXML
    void backbuttonAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/ProjectTables/Admin_Home.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin Home");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void ExitCtrl(ActionEvent event) throws IOException {
        System.out.println("Exitting");
        System.exit(0);
    } 
    
}
