/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntryPages;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Admission_FormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private ComboBox<String>grdcmbx;
    @FXML private ComboBox<String>seccmbx;
    @FXML private ComboBox<String>sesscmbx;
    @FXML private ComboBox<String>BGcmbx;
    
    @FXML private DatePicker BDPicker;
    
    @FXML private TextField F_NAME;
    @FXML private TextField L_NAME;
    @FXML private TextField STD_ID;
    @FXML private TextField ADDR;
    @FXML private TextField CON_NUMB;
    @FXML private TextField DESC;
    
    @FXML private Button submitbtn;
    @FXML private Button resetbtn;
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
    void resetButtonAction(ActionEvent event){
        grdcmbx.setPromptText("Grade");
        seccmbx.setPromptText("Section");
        sesscmbx.setPromptText("Session");
        BGcmbx.setValue("Blood Group");   //BGcmbx.setItems(BGopts);  BGcmbx.setPromptText("Blood Group");
        F_NAME.setText("");
        L_NAME.setText("");
        STD_ID.setText("");
        ADDR.setText("");
        CON_NUMB.setText("");
        DESC.setText("");/*
        grdcmbx.setItems(grdopts);
        seccmbx.setItems(secopts);
        sesscmbx.setItems(sessopts);
        BGcmbx.setItems(BGopts);*/
    }
    
    @FXML
    void submitButtonAction(ActionEvent event){
        String id,fnme,lnme,grd,sc,ss,adr,num,des,bg,dte;
        id = STD_ID.getText(); fnme = F_NAME.getText(); lnme = L_NAME.getText(); grd = grdcmbx.getValue(); sc = seccmbx.getValue(); ss = sesscmbx.getValue();
        adr = ADDR.getText(); num = CON_NUMB.getText(); des = DESC.getText(); bg = BGcmbx.getValue(); dte = BDPicker.getValue().toString();
        //String sql = "INSERT INTO STUDENTS VALUES ("+STD_ID.getText()+","+F_NAME.getText()+","+L_NAME.getText()+","+grdcmbx.getValue()+","+seccmbx.getValue()+","+sesscmbx.getValue()+","+ADDR.getText()+","+CON_NUMB.getText()+","+DESC.getText()+","+BGcmbx.getValue()+","+"TO_DATE("+BDPicker.getValue()+", 'YYYY-MM-DD')"+")";                                                  
        //String sql = "INSERT INTO STUDENTS VALUES (156485,SASD,DJALA,4,C,2017-18,KDLKJALSKD,15242011,GOOD,O+,TO_DATE(2017-11-26, 'YYYY-MM-DD'))";    
        String sql = "INSERT INTO STUDENTS VALUES(?,?,?,?,?,?,?,?,?,?,TO_DATE(?, 'YYYY-MM-DD'))";
        //String sql = "INSERT INTO STUDENTS VALUES ('156485','SASD','DJALA','4','C','2017-18','KDLKJALSKD','15242011','GOOD','O+',TO_DATE('2017-11-26', 'YYYY-MM-DD'))";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, fnme);
            pst.setString(3, lnme);
            pst.setString(4, grd);
            pst.setString(5, sc);
            pst.setString(6, ss);
            pst.setString(7, adr);
            pst.setString(8, num);
            pst.setString(9, des);
            pst.setString(10, bg);
            pst.setString(11, dte);
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
            Parent root = FXMLLoader.load(getClass().getResource("Entry_Forms.fxml"));/* Exception */
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
