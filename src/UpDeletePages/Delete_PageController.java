/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpDeletePages;

import ProjectTables.OracleDBMS;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Delete_PageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML Button extbtn;
    @FXML Button backbtn;
    @FXML Button signoutbtn;
    @FXML Button stdbtn;
    @FXML Button teabtn;
    @FXML Button empbtn;
    @FXML Button subjbtn;
    @FXML Button exmbtn;
    @FXML Button feebtn;
    @FXML Button evntbtn;
    @FXML Button adminbtn;
    
    @FXML ComboBox<String> stdcmbx;
    @FXML ComboBox<String> teacmbx;
    @FXML ComboBox<String> empcmbx;
    @FXML ComboBox<String> subjcmbx;
    @FXML ComboBox<String> exmcmbx;
    @FXML ComboBox<String> feecmbx;
    @FXML ComboBox<String> evntcmbx;
    @FXML ComboBox<String> admincmbx;
    
    @FXML TextField stdfld;
    @FXML TextField teafld;
    @FXML TextField empfld;
    @FXML TextField subjfld;
    @FXML TextField exmfld;
    @FXML TextField feefld;
    @FXML TextField evntfld;
    @FXML TextField adminfld;
    
    ObservableList<String>stdopts = FXCollections.observableArrayList("STUDENT_ID", "FIRST_NAME", "LAST_NAME", "GRADE", "SECTION", "SESSIONS", "CONTACT_NUMBER", "BLOOD_GROUP", "BIRTH_DATE");
    ObservableList<String>teaopts = FXCollections.observableArrayList("TEACHER_ID","FIRST_NAME","LAST_NAME","SUBJECT","JOIN_DATE","BIRTH_DATE","SALARY","BLOOD_GROUP");
    ObservableList<String>empopts = FXCollections.observableArrayList("EMPLOYEE_ID","FIRST_NAME","LAST_NAME","JOB_TITLE","JOIN_DATE","BIRTH_DATE","SALARY","BLOOD_GROUP");
    ObservableList<String>subjopts = FXCollections.observableArrayList("SUBJECT_CODE", "SUBJECT_NAME");
    ObservableList<String>exmopts = FXCollections.observableArrayList("EXAM_ID","EXAM_NAME");
    ObservableList<String>feeopts = FXCollections.observableArrayList("FEE_ID","FEE_AMOUNT");
    ObservableList<String>evntopts = FXCollections.observableArrayList("EVENT_ID", "EVENT_NAME");
    ObservableList<String>adminopts = FXCollections.observableArrayList("USER_NAME");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stdcmbx.setItems(stdopts);
        teacmbx.setItems(teaopts);
        empcmbx.setItems(empopts);
        subjcmbx.setItems(subjopts);
        exmcmbx.setItems(exmopts);
        feecmbx.setItems(feeopts);
        evntcmbx.setItems(evntopts); 
        admincmbx.setItems(adminopts);   }    
    
    @FXML
    void stdbtnAction(ActionEvent event){
        String attr, val ; 
        attr = stdcmbx.getValue(); val = stdfld.getText();
        String sql = "DELETE FROM STUDENTS WHERE "+attr+" = ? ";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            System.out.println("Exception in deleting STUDENTS");
        }
    }
    
    @FXML
    void teabtnAction(ActionEvent event){
        String attr, val ; 
        attr = teacmbx.getValue(); val = teafld.getText(); //System.out.println(attr+"\t"+val);
        String sql = "DELETE FROM TEACHERS WHERE "+attr+" = ?";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in deleting TEACHERS");
            //e.printStackTrace();
        }
    }
    
    @FXML
    void empbtnAction(ActionEvent event){
        String attr, val ; 
        attr = empcmbx.getValue(); val = empfld.getText(); //System.out.println(attr+"\t"+val);
        String sql = "DELETE FROM EMPLOYEES WHERE "+attr+" = ?";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in deleting EMPLOYEES");
            //e.printStackTrace();
        }
    }
    
    @FXML
    void subjbtnAction(ActionEvent event){
        String attr, val ; 
        attr = subjcmbx.getValue(); val = subjfld.getText(); //System.out.println(attr+"\t"+val);
        String sql = "DELETE FROM SUBJECT WHERE "+attr+" = ?";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in deleting SUBJECT");
            //e.printStackTrace();
        }
    }
    
    @FXML
    void exmbtnAction(ActionEvent event){
        String attr, val ; 
        attr = exmcmbx.getValue(); val = exmfld.getText(); //System.out.println(attr+"\t"+val);
        String sql = "DELETE FROM EXAMS WHERE "+attr+" = ?";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in deleting EXAMS");
            //e.printStackTrace();
        }
    }
    
    @FXML
    void feebtnAction(ActionEvent event){
        String attr, val ; 
        attr = feecmbx.getValue(); val = feefld.getText();
        String sql = "DELETE FROM FEES WHERE "+attr+" = ? ";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in deleting FEES");
        }
    }
    
    @FXML
    void evntbtnAction(ActionEvent event){
        String attr, val ; 
        attr = evntcmbx.getValue(); val = evntfld.getText();
        String sql = "DELETE FROM EVENTS WHERE "+attr+" = ? ";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in deleting EVENTS");
        }
    }
    
    @FXML
    void adminbtnAction(ActionEvent event){
        String attr, val ; 
        attr = admincmbx.getValue(); val = adminfld.getText();
        String sql = "DELETE FROM ADMIN WHERE "+attr+" = ? ";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, attr);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception in deleting ADMIN");
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
