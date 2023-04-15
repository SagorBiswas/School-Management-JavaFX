/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Admin_HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button AllStdbtn;
    @FXML private Button AllTeabtn;
    @FXML private Button AllEmpbtn;
    @FXML private Button Stdbtn;
    @FXML private Button Teabtn;
    @FXML private Button Empbtn;
    
    @FXML private ComboBox<String>stdcmbx;
    @FXML private ComboBox<String>teacmbx;
    @FXML private ComboBox<String>empcmbx;
    
    @FXML private TextField stdtxtfld;
    @FXML private TextField teatxtfld;
    @FXML private TextField emptxtfld;
    
    @FXML private Text txt1;
    @FXML private Text txt2;
    @FXML private Text txt3;
    @FXML private Text txt4;
    @FXML private Text txt5;
    @FXML private Text txt6;
    
    @FXML private Button signoutbtn;
    @FXML private Button extbtn;
    
    @FXML private Button updatebtn;
    @FXML private Button deletebtn;
    @FXML private Button entrybtn;
    
    
    //create Combobox data
    ObservableList<String>stdopts = FXCollections.observableArrayList("STUDENT_ID", "FIRST_NAME", "LAST_NAME", "GRADE", "SECTION", "SESSIONS", "CONTACT_NUMBER", "BLOOD_GROUP", "BIRTH_DATE");
    ObservableList<String>teaopts = FXCollections.observableArrayList("TEACHER_ID","FIRST_NAME","LAST_NAME","SUBJECT","JOIN_DATE","BIRTH_DATE","SALARY","BLOOD_GROUP");
    ObservableList<String>empopts = FXCollections.observableArrayList("EMPLOYEE_ID","FIRST_NAME","LAST_NAME","JOB_TITLE","JOIN_DATE","BIRTH_DATE","SALARY","BLOOD_GROUP");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stdcmbx.setItems(stdopts);
        teacmbx.setItems(teaopts);
        empcmbx.setItems(empopts);
    }    
    /*
    @FXML
    private void allStdAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("ShowStudents_Off01.fxml")); /* Exception *//*
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("Students Table");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
    
    @FXML
    private void allTeaAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ShowTeachers_Off.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            System.out.println("Loaded in alltea");
            ShowTeachers_OffController sfs = Loader.getController();
            sfs.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Teachers");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in allTeaAction");
        }
    }
    @FXML
    private void allEmpAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            System.out.println(empcmbx.getValue()+" "+ emptxtfld.getText());
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ShowEmployees_Off.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            
            ShowEmployees_OffController sfs = Loader.getController();
            sfs.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Students");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in allEmpAction");
        }
    }
    @FXML
    private void StdAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            System.out.println(stdcmbx.getValue()+" "+ stdtxtfld.getText());
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ShowSomeStudents.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            
            ShowSomeStudentsController sfs = Loader.getController();
            sfs.load(stdcmbx.getValue(), stdtxtfld.getText().toUpperCase());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Students");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in StdAction");
        }
    }
    
    @FXML
    private void allStdAction2(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            System.out.println(stdcmbx.getValue()+" "+ stdtxtfld.getText());
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ShowSomeStudents.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            
            ShowSomeStudentsController sfs = Loader.getController();
            sfs.load2();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Students");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in StdAction");
        }
    }
    
    @FXML
    private void TeaAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            System.out.println(teacmbx.getValue()+" "+ teatxtfld.getText());
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ShowTeachers_Off.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            System.out.println("Loaded in tea");
            ShowTeachers_OffController sfs = Loader.getController();
            sfs.load2(teacmbx.getValue(), teatxtfld.getText().toUpperCase());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Teachers");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in TeaAction");
            e.printStackTrace();
        }
    }
    @FXML
    private void EmpAction(ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            System.out.println(empcmbx.getValue()+" "+ emptxtfld.getText());
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ShowEmployees_Off.fxml"));/* Exception */
            Parent root = (Parent)Loader.load();
            System.out.println("Loaded in emp");
            ShowEmployees_OffController sfs = Loader.getController();
            sfs.load2(empcmbx.getValue(), emptxtfld.getText().toUpperCase());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employees");
            stage.show();
            
        } catch (Exception e)
        {
            System.out.println("Exception in TeaAction");
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void signoutAction(ActionEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        
        Parent root1 = FXMLLoader.load(getClass().getResource("Admin_Login.fxml")); /* Exception */
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.setTitle("Admin Login");
        stage.show();
    }
    
    @FXML
    private void exitbtnAction(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    private void UpdateAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/UpDeletePages/Update_Page.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("Update Home");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    private void DeleteAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/UpDeletePages/Delete_Page.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setTitle("Delete Page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    @FXML
    private void EntryAction(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            
            Parent root1 = FXMLLoader.load(getClass().getResource("/EntryPages/Entry_Forms.fxml")); /* Exception */
            Scene scene = new Scene(root1);
            stage.setTitle("Entry_Forms");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
