/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */


public class Admin_LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Button loginbtn;
    @FXML private Button backbtn;
    @FXML private Button exitbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public boolean validateLogin()
    {
        boolean success = false;
        String sql = "SELECT * FROM ADMIN WHERE USER_NAME = ? AND PASSWORD=?";
        
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
                success = true;
            }
            //success = true ;
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
    
    @FXML
    void loginAction(ActionEvent event) throws IOException
    {
        //String validUserName = "admin";
        //String validPassword = "123";
        String user = username.getText();
        String pass= password.getText();
        //boolean success = new Users().validateLogin(userName, password);
        if (true) //validateLogin())
        {
            // successful login
            try
            {
                System.out.println("Logged In");
                Node node = (Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Admin_Home.fxml"));/* Exception */
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Admin Home");
                stage.show();
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }
    
    @FXML
    void backbuttonAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("First Page");
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
