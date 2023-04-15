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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Admin_EntryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button submitbtn;
    @FXML private Button resetbtn;
    @FXML private Button backbtn;
    @FXML private Button signOutbtn;
    @FXML private Button exitbtn;
    
    @FXML private TextField usernme;
    @FXML private TextField pass;
    @FXML private TextField repass;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void resetButtonAction(ActionEvent event){
        pass.setText("");
        repass.setText("");
        usernme.setText("");
    }
    
    @FXML
    void submitButtonAction(ActionEvent event){
        String nme, id, rid ;
        id = pass.getText(); rid = repass.getText(); nme = usernme.getText();
        if(!id.equals(rid)) return ;
        String sql = "INSERT INTO ADMIN VALUES(?,?)";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nme);
            pst.setString(2, id);
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
            Parent root = FXMLLoader.load(getClass().getResource("/EntryPages/Entry_Forms.fxml"));/* Exception */
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
