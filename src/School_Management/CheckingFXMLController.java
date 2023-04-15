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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */

public class CheckingFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML TextField txt1;
    @FXML TextField txt2;
    @FXML Button btn;
    
    @FXML
    void buttonAction(ActionEvent act){
        txt1.setText("He Pushed Me");
        txt2.setText("I didn't push you");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
