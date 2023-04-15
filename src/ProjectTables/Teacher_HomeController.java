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
public class Teacher_HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML private Button feesbtn;
    @FXML private Button stdbtn;
    @FXML private Button empbtn;
     @FXML private Button backbtn;
    @FXML private Button signoutbtn;
    @FXML private Button exitbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void showTeachersAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("ShowTeachers_Std.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Teachers Table");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
     @FXML
    public void showStudentsAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("ShowStudets_Offo1.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Students Table");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void showEmployeesAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("ShowEmployees_forTeachers.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employees Table");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
   
    
    
    
    
    
     @FXML
    void signoutbuttonAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Student_Login.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Login");
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
            Parent root = FXMLLoader.load(getClass().getResource("Student_Login.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Login");
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
