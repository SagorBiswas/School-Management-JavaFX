/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntryPages;

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
public class Entry_FormsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button Stdbtn;
    @FXML private Button Teabtn;
    @FXML private Button Empbtn;
    @FXML private Button Subjbtn;
    @FXML private Button Eventbtn;
    @FXML private Button exambtn;
    @FXML private Button Feebtn;
    @FXML private Button marksbtn;
    @FXML private Button feeAssignbtn;
    @FXML private Button paticipatebtn;
    @FXML private Button newAdminbtn;
    @FXML private Button signOutbtn;
    @FXML private Button backbtn;
    @FXML private Button exitbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void StdbtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Admission_Form.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Admission Form");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in StdbtnAction");
        }
    }
    
    @FXML
    private void TeabtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Teacher_Entry.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Teacher Entry Form");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in TeabtnAction");
        }
    }
    
    @FXML
    private void EmpbtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Employee_Entry.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employee Entry Form");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in EmpbtnAction");
        }
    }
    
    @FXML
    private void SubjbtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Subject_Entry.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Subject Entry Page");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in SubjbtnAction");
        }
    }
    
    @FXML
    private void EventbtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Event_Entry.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Event Entry Page");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in EventbtnAction");
        }
    }
    
    @FXML
    private void exambtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Exam_Entry.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Exam Entry Page");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in exambtnAction");
        }
    }
    
    @FXML
    private void FeebtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Fee_Entry.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Fee Entry Page");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in FeebtnAction");
        }
    }
    
    @FXML
    private void marksbtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Entry_Forms.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Admission Form");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in marksbtnAction");
        }
    }
    
    @FXML
    private void feeAssignbtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Assign_Fees.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Admission Form");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in feeAssignbtnAction");
        }
    }
    
    @FXML
    private void paticipatebtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Entry_Forms.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Admission Form");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in StdbtnAction");
        }
    }
    
    @FXML
    private void newAdminbtnAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Admin_Entry.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin Entry Page");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in newAdminbtnAction");
        }
    }
    
    
    @FXML
    private void backbtnAction(ActionEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        
        Parent root1 = FXMLLoader.load(getClass().getResource("/ProjectTables/Admin_Home.fxml")); /* Exception */
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.setTitle("Admin Home");
        stage.show();
    }
    
    @FXML
    private void signoutAction(ActionEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        
        Parent root1 = FXMLLoader.load(getClass().getResource("/ProjectTables/Admin_Login.fxml")); /* Exception */
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.setTitle("Admin Login");
        stage.show();
    }
    
    @FXML
    private void exitbtnAction(ActionEvent event){
        System.exit(0);
    }
    
}