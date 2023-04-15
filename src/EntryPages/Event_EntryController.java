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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Event_EntryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button submitbtn;
    @FXML private Button resetbtn;
    @FXML private Button backbtn;
    @FXML private Button signOutbtn;
    @FXML private Button exitbtn;
    
    @FXML private TextField Ev_nme;
    @FXML private TextField Ev_ID;
    @FXML private TextField plc;
    @FXML private TextField prsd;
    
    @FXML private DatePicker DP;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void resetButtonAction(ActionEvent event){
        Ev_nme.setText("");
        Ev_ID.setText("");
        plc.setText("");
        prsd.setText("");
        DP.setPromptText("");
    }
    
    @FXML
    void submitButtonAction(ActionEvent event){
        String id, nme, plce, prsdnt, dte ;
        id = Ev_ID.getText(); nme = Ev_nme.getText(); plce = plc.getText();
        prsdnt = prsd.getText(); dte = DP.getValue().toString();
        String sql = "INSERT INTO EVENTS VALUES(?,?,TO_DATE(?, 'YYYY-MM-DD'),?,?)";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, nme);
            pst.setString(3, dte);
            pst.setString(4, plce);
            pst.setString(5, prsdnt);
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            System.out.println("Exception in inserting event");
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
