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
public class Student_HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button feesbtn;
    @FXML private Button gpabtn;
    @FXML private Button posbtn;
    
    @FXML private Button backbtn;
    @FXML private Button signoutbtn;
    @FXML private Button exitbtn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void posbtnAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Std_ID_pos_Input.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ID Input");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void gpabtnAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Std_ID_GPA_Input.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ID Input");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void showFeesAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Std_ID_Input.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ID Input");
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
