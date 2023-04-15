/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class LoginPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button button ;
    @FXML
    private TextField text;
    @FXML 
    private PasswordField pass;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    
    public void Login(ActionEvent event){
        if(text.getText().equals("Sagor") && pass.getText().equals("1234")){
            label1.setText("");
            label2.setText("Login Success");
        }
        else {
            label2.setText("");
            label1.setText("UserName or Password Incorrect");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
