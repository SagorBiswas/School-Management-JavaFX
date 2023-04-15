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
import java.sql.CallableStatement;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class Assign_FeesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button Assignid;
    @FXML private Button Assignsess;
    @FXML private Button Assigngrd;
    @FXML private Button Assignsect;
    
    @FXML private Button backbtn;
    @FXML private Button signOutbtn;
    @FXML private Button exitbtn;
    @FXML private Button clrbtn;
    
    @FXML private ComboBox<String> sesscmbx;
    @FXML private ComboBox<String> grdcmbx;
    @FXML private ComboBox<String> seccmbx;
    
    @FXML private TextField stdid;
    @FXML private TextField feeid;
    
    ObservableList<String>grdopts = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
    ObservableList<String>secopts = FXCollections.observableArrayList("A","B","C");
    ObservableList<String>sessopts = FXCollections.observableArrayList("2010-11","2011-12","2012-13","2013-14","2014-15","2015-16","2016-17","2017-18","2018-19","2019-20","2020-21","2021-22","2022-23","2023-24","2024-25");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sesscmbx.setItems(sessopts);
        grdcmbx.setItems(grdopts);
        seccmbx.setItems(secopts);
    }    
    
    @FXML
    void assignidbuttonAction(ActionEvent event){
        String fid, stid;
        fid = feeid.getText();  stid = stdid.getText();
        String sql = "INSERT INTO FEES_PAYMENT VALUES(?,?,?)";
        System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fid);
            pst.setString(2, stid);
            pst.setString(3, "DUE");
            ResultSet rs = pst.executeQuery();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in inserting fees payment (id)");
        }
    }
    
    @FXML
    void assignsessbuttonAction(ActionEvent event){
        String session, fid;
        session = sesscmbx.getValue().toString(); fid = feeid.getText();
        String sql = "{call FEEASSIGN_SESS(?, ?)}";
        System.out.println(session);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            CallableStatement cStmt = con.prepareCall(sql);
            cStmt.setString(1, fid);
            cStmt.setString(2, session);
            ResultSet rs = cStmt.executeQuery();
            cStmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in inserting fees payment (SESS)");
        }
    }
    
    @FXML
    void assigngrdbuttonAction(ActionEvent event){
        String grd, fid;
        grd = grdcmbx.getValue();  fid = feeid.getText();
        String sql = "{call FEEASSIGN_GRD(?, ?)}";
        //System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            CallableStatement cStmt = con.prepareCall(sql);
            cStmt.setString(1, fid);
            cStmt.setString(2, grd);
            ResultSet rs = cStmt.executeQuery();
            cStmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in inserting fees payment (SESS)");
        }
    }
    
    @FXML
    void assignsectbuttonAction(ActionEvent event){
        String sect,grd, fid;
        sect = seccmbx.getValue();  grd = grdcmbx.getValue();  fid = feeid.getText();
        String sql = "{call FEEASSIGN_GRD_SEC(?, ?, ?)}";
        //System.out.println(sql);
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            CallableStatement cStmt = con.prepareCall(sql);
            cStmt.setString(1, fid);
            cStmt.setString(2, grd);
            cStmt.setString(3, sect);
            ResultSet rs = cStmt.executeQuery();
            cStmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in inserting fees payment (SESS)");
        }
    }
    
    @FXML
    void resetbuttonAction(ActionEvent event){
        stdid.setText("");
        feeid.setText("");
        sesscmbx.setPromptText("");
        grdcmbx.setPromptText("");
        seccmbx.setPromptText("");
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
            Parent root = FXMLLoader.load(getClass().getResource("Entry_Forms.fxml"));/* Exception */
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
