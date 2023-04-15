/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class ShowGPA_StdController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button backbtn;
    @FXML private Button signoutbtn;
    @FXML private Button exitbtn;
    
    @FXML private TextField txtfld;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void Showgpa(String xm_id, String std_id)
    {
        //String sql = "{call SHOW_GRADE(?, ?)}";
        String sql = "SELECT SHOW_GRADE(?,?)";
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            CallableStatement cStmt = con.prepareCall(sql);
            cStmt.setString(1, xm_id);
            cStmt.setString(2, std_id);
            ResultSet rs = cStmt.executeQuery();
            cStmt.close();
            con.close();
            txtfld.setText(rs.toString());
        }
        catch(Exception e)
        {
            System.out.println("Exception in Showing GPA");
        }
    }
    
     @FXML
    void signoutbuttonAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Student_Login.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Login");
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
            Parent root = FXMLLoader.load(getClass().getResource("Student_Home01.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Home");
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
