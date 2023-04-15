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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Exam_EntryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField Egzam_nme;
    @FXML private TextField Egzam_id;
    @FXML private ComboBox ycmbx;
    
    @FXML private Button submitbtn;
    @FXML private Button resetbtn;
    @FXML private Button backbtn;
    @FXML private Button signOutbtn;
    @FXML private Button exitbtn;
    
     ObservableList<String>BGopts = FXCollections.observableArrayList("A+","A-","O+","O-","B+","B-","AB+","AB-");
    ObservableList<String>years = FXCollections.observableArrayList("2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
            "2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ycmbx.setItems(years);
    }    
    
    @FXML
    void resetButtonAction(ActionEvent event){
        Egzam_nme.setText("");
        Egzam_id.setText("");
        ycmbx.setPromptText("Year");
    }
    
    @FXML
    void submitButtonAction(ActionEvent event){
        String nm, id, yr;
        nm = Egzam_nme.getText(); id = Egzam_id.getText(); yr = ycmbx.getValue().toString();
        String sql = "INSERT INTO EXAMS VALUES(?,?,?)";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nm);
            pst.setString(3, yr);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            System.out.println("Exception in inserting Exam");
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
            //e.printStackTrace();
            System.out.println("Exception in SignOut");
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
            //e.printStackTrace();
            System.out.println("Exception while backing off");
        }
    }
    @FXML
    private void ExitCtrl(ActionEvent event) throws IOException {
        System.out.println("Exitting");
        System.exit(0);
    }
    
}
