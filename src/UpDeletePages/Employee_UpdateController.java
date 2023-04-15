/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpDeletePages;

import ProjectTables.Employees_Off;
import ProjectTables.OracleDBMS;
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
public class Employee_UpdateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private TextField EMP_ID;
    
    @FXML private TextField F_NAME;
    @FXML private TextField L_NAME;
    @FXML private TextField JOB;
    @FXML private TextField SAL;
    
    @FXML private ComboBox<String>BGcmbx;
    
    @FXML private Button loadbtn;
    @FXML private Button savebtn;
    @FXML private Button canclbtn;
    @FXML private Button backbtn;
    @FXML private Button signOutbtn;
    @FXML private Button exitbtn;
    
    ObservableList<String>BGopts = FXCollections.observableArrayList("A+","A-","O+","O-","B+","B-","AB+","AB-");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BGcmbx.setItems(BGopts);
    }   
    
    @FXML
    void loadbtnAction(ActionEvent event){
        load();
    }
    
    public void load()
    {
        String attr, val;
        attr = "EMPLOYEE_ID"; val = EMP_ID.getText();
        List<List<String>> EmployeeDataList = new Employees_Off().getSomeEmployees(attr,val);
        for (List<String> row : EmployeeDataList)
        {
            F_NAME.setText(row.get(1));
            L_NAME.setText(row.get(2));
            JOB.setText(row.get(3));
            SAL.setText(row.get(6));
            BGcmbx.setValue(row.get(7));
        }
    }
    
    @FXML
    void saveButtonAction(ActionEvent event){
        String id,fnme,lnme,sub, salry, bg;
        id = EMP_ID.getText(); fnme = F_NAME.getText(); lnme = L_NAME.getText();
        sub = JOB.getText(); salry = SAL.getText(); bg = BGcmbx.getValue();
        String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, JOB_TITLE = ?, SALARY = ?, BLOOD_GROUP = ? WHERE EMPLOYEE_ID = ?";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fnme);
            pst.setString(2, lnme);
            pst.setString(3, sub);
            pst.setString(4, salry);
            pst.setString(5, bg);
            pst.setString(6, id);
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
