/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpDeletePages;

import ProjectTables.OracleDBMS;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
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
public class Event_UpdateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private TextField EVENT_ID;
    
    @FXML private TextField EVENT_NAME;
    @FXML private TextField PLACE;
    @FXML private TextField DATE;
    @FXML private TextField PRESIDENT;
    
    @FXML private Button loadbtn;
    @FXML private Button savebtn;
    @FXML private Button canclbtn;
    @FXML private Button backbtn;
    @FXML private Button signOutbtn;
    @FXML private Button exitbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void load(){
        String Value = EVENT_ID.getText(); 
        String sql = "SELECT * FROM EVENTS WHERE EVENT_ID = ?";
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Value);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Connected");
            if (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("EVENT_ID"));
                row.add(rs.getString("EVENT_NAME"));
                row.add(rs.getString("DATE"));
                row.add(rs.getString("PLACE"));
                row.add(rs.getString("PRESIDENT"));
                
                EVENT_NAME.setText(row.get(1));
                PLACE.setText(row.get(3));
                DATE.setText(row.get(2));
                PRESIDENT.setText(row.get(4));
            } 
            else System.out.println("No Data found in this event id");                      
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    void loadbtnAction(ActionEvent event){
        EVENT_NAME.setText("");
        PLACE.setText("");
        DATE.setText("");
        PRESIDENT.setText("");
        load();
    }
    
    @FXML
    void saveButtonAction(ActionEvent event){
        String id,fnme,plc, prsd, dte ;
        id = EVENT_ID.getText(); fnme = EVENT_NAME.getText(); plc = PLACE.getText(); prsd = PRESIDENT.getText();  dte = DATE.getText();
        String sql = "UPDATE EVENTS SET EVENT_NAME = ?, PLACE = ?,  PRESIDENT = ? WHERE EVENT_ID = ? ";//  "+id+"
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fnme);
            pst.setString(2, plc);
            //pst.setString(3, dte);//DATE =  TO_DATE(SUBSTR(?,1,10), 'YYYY-MM-DD'),
            pst.setString(3, prsd);
            pst.setString(4, id);
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
