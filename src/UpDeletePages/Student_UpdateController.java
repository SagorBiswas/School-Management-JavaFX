/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpDeletePages;

import ProjectTables.OracleDBMS;
import ProjectTables.Students_Off;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Student_UpdateController implements Initializable {

    /** 
     * Initializes the controller class.
     */
    @FXML private TextField STD_ID;
    
    @FXML private TextField F_NAME;
    @FXML private TextField L_NAME;
    @FXML private TextField ADDR;
    @FXML private TextField CON_NUMB;
    @FXML private TextField DESC;
    
    @FXML private ComboBox<String>grdcmbx;
    @FXML private ComboBox<String>seccmbx;
    @FXML private ComboBox<String>sesscmbx;
    @FXML private ComboBox<String>BGcmbx;
    
    @FXML private Button loadbtn;
    @FXML private Button savebtn;
    @FXML private Button canclbtn;
    @FXML private Button backbtn;
    @FXML private Button signOutbtn;
    @FXML private Button exitbtn;
    
    ObservableList<String>secopts = FXCollections.observableArrayList("A","B","C");
    ObservableList<String>sessopts = FXCollections.observableArrayList("2010-11","2011-12","2012-13","2013-14","2014-15","2015-16","2016-17","2017-18","2018-19","2019-20","2020-21","2021-22","2022-23","2023-24","2024-25");
    ObservableList<String>BGopts = FXCollections.observableArrayList("A+","A-","O+","O-","B+","B-","AB+","AB-");
    ObservableList<String>grdopts = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        grdcmbx.setItems(grdopts);
        seccmbx.setItems(secopts);
        sesscmbx.setItems(sessopts);
        BGcmbx.setItems(BGopts);
    }    
    
    @FXML
    void canclButtonAction(ActionEvent event){
        load();
    }
    
    @FXML
    void saveButtonAction(ActionEvent event){
        String id,fnme,lnme,grd,sc,ss,adr,num,des,bg,dte,ATTRSESS;  ATTRSESS = "SESSIONS";
        id = STD_ID.getText(); fnme = F_NAME.getText(); lnme = L_NAME.getText(); grd = grdcmbx.getValue(); sc = seccmbx.getValue(); ss = sesscmbx.getValue();
        adr = ADDR.getText(); num = CON_NUMB.getText(); des = DESC.getText(); bg = BGcmbx.getValue();
        String sql = "UPDATE STUDENTS SET FIRST_NAME = ?, LAST_NAME = ?, GRADE = ?, SECTION = ?, "+ATTRSESS+" = ?, ADDRESS = ?, CONTACT_NUMBER = ?, REMARKS = ?, BLOOD_GROUP = ? WHERE STUDENT_ID = ?";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fnme);
            pst.setString(2, lnme);
            pst.setString(3, grd);
            pst.setString(4, sc);
            pst.setString(5, ss);
            pst.setString(6, adr);
            pst.setString(7, num);
            pst.setString(8, des);
            pst.setString(9, bg);
            pst.setString(10, id);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    void loadbtnAction(ActionEvent event){
        load();
    }
    
    public void load()
    {
        String attr, val;
        attr = "STUDENT_ID"; val = STD_ID.getText();
        List<List<String>> StudentDataList = new Students_Off().getSomeStudents(attr,val);
        for (List<String> row : StudentDataList)
        {
            F_NAME.setText(row.get(1));
            L_NAME.setText(row.get(2));
            ADDR.setText(row.get(6));
            CON_NUMB.setText(row.get(7));
            DESC.setText(row.get(8));
            grdcmbx.setValue(row.get(3));
            seccmbx.setValue(row.get(4));
            sesscmbx.setValue(row.get(5));
            BGcmbx.setValue(row.get(9));
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
            Parent root = FXMLLoader.load(getClass().getResource("/UpDeletePages/Update_Page.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Entry Forms");
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
