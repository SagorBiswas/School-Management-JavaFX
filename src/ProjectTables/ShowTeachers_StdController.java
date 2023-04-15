/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class ShowTeachers_StdController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane anc;
    @FXML
    private TableView tableView;
    @FXML 
    private Button backbtn;
    @FXML
    private Button SignOutbtn;
    @FXML
    private Button Loadbtn;
    
    @FXML TableColumn<Teacher_Std,String>TEACHER_ID;
    @FXML TableColumn<Teacher_Std,String>TEACHER_NAME;
    @FXML TableColumn<Teacher_Std,String>SUBJECT;

    ObservableList<Teacher_Std> data;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TEACHER_ID.setCellValueFactory(new PropertyValueFactory<Teacher_Std,String>("TEACHER_ID"));
        TEACHER_NAME.setCellValueFactory(new PropertyValueFactory<Teacher_Std,String>("TEACHER_NAME"));
        SUBJECT.setCellValueFactory(new PropertyValueFactory<Teacher_Std,String>("SUBJECT"));
        
        load();
    }    
    
    
     public void load()
    {
        data = FXCollections.observableArrayList();

        List<List<String>> TeacherDataList = new Teachers_std().getAllTeachers();
        for (List<String> row : TeacherDataList)
        {
            data.add(new Teacher_Std(row.get(0), row.get(1), row.get(2)));
        }
        tableView.setEditable(true);
        tableView.setItems(data);

    }

   @FXML
    void signoutbuttonAction(ActionEvent event)
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
    void backbuttonAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Teacher_Home.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Teacher Home");
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

//    void setMain(Main main)
//    {
//        this.main = main;
//    }

    public void refreshTable()
    {
        for (int i = 0; i < tableView.getColumns().size(); i++)
        {
            ((TableColumn) (tableView.getColumns().get(i))).setVisible(false);
            ((TableColumn) (tableView.getColumns().get(i))).setVisible(true);
        }
    }
    
    @FXML
    private void ExitCtrl(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    
}
