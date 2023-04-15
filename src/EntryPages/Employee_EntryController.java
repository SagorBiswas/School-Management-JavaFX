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
public class Employee_EntryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField F_NAME;
    @FXML private TextField L_NAME;
    @FXML private TextField E_ID;
    @FXML private TextField salry;
    @FXML private TextField job_tle;
    
    @FXML private ComboBox<String> BGcmbx;
    
    @FXML private DatePicker jdtp;
    @FXML private DatePicker dobdtp;
    
    @FXML private Button submitbtn;
    @FXML private Button resetbtn;
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
    void resetButtonAction(ActionEvent event){
        E_ID.setText("");
        F_NAME.setText("");
        L_NAME.setText("");
        salry.setText("");
        job_tle.setText("");
        BGcmbx.setPromptText("");
        //BGcmbx.setPromptText("Blood Group");
        dobdtp.setPromptText("Date Of Birth");
        jdtp.setPromptText("Join Date");
    }
    
    @FXML
    void submitButtonAction(ActionEvent event){
        String id,fnme,lnme,bdte,jbtle,sal,bg,jdte;
        id = E_ID.getText(); fnme = F_NAME.getText(); lnme = L_NAME.getText(); jbtle = job_tle.getText();
        bdte = dobdtp.getValue().toString(); sal = salry.getText(); bg = BGcmbx.getValue(); jdte = jdtp.getValue().toString();
        String sql = "INSERT INTO EMPLOYEES VALUES(?,?,?,?,TO_DATE(?, 'YYYY-MM-DD'),TO_DATE(?, 'YYYY-MM-DD'),?,?)";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, fnme);
            pst.setString(3, lnme);
            pst.setString(4, jbtle);
            pst.setString(5, jdte);
            pst.setString(6, bdte);
            pst.setString(7, sal);
            pst.setString(8, bg);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            System.out.println("Exception in inserting teacher");
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
