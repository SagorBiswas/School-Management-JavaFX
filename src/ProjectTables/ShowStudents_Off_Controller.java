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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class ShowStudents_Off_Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView tableView;
    @FXML 
    private Button backbtn;
    @FXML
    private Button SignOutbtn;
    @FXML
    private Button Loadbtn;
    @FXML
    private Button Extbtn;
    
    @FXML TableColumn<Student_Off,String>STUDENT_ID;
    @FXML TableColumn<Student_Off,String>FIRST_NAME;
    @FXML TableColumn<Student_Off,String>LAST_NAME;
    @FXML TableColumn<Student_Off,String>GRADE;
    @FXML TableColumn<Student_Off,String>SECTION;
    @FXML TableColumn<Student_Off,String>SESSION;
    @FXML TableColumn<Student_Off,String>ADDRESS;
    @FXML TableColumn<Student_Off,String>CONTACT_NUMBER;
    @FXML TableColumn<Student_Off,String>REMARKS;
    @FXML TableColumn<Student_Off,String>BLOOD_GROUP;
    @FXML TableColumn<Student_Off,String>BIRTH_DATE;

    final ObservableList<Student_Off> data = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        STUDENT_ID.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("STUDENT_ID"));
        FIRST_NAME.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("FIRST_NAME"));
        LAST_NAME.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("LAST_NAME"));
        GRADE.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("GRADE"));
        SECTION.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("SECTION"));
        SESSION.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("SESSION"));
        ADDRESS.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("ADDRESS"));
        CONTACT_NUMBER.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("CONTACT_NUMBER"));
        REMARKS.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("REMARKS"));
        BLOOD_GROUP.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("BLOOD_GROUP"));
        BIRTH_DATE.setCellValueFactory(new PropertyValueFactory<Student_Off,String>("BIRTH_DATE"));
        
        load();
        
        tableView.setItems(data);
        System.out.println(data.get(1).toString());
    }    
    
    
    public void load()
    {
        //data = FXCollections.observableArrayList();

        List<List<String>> StudentDataList = new Students_Off().getAllStudents();
        for (List<String> row : StudentDataList)
        {
            Student_Off stdoff = new Student_Off(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), row.get(7), row.get(8), row.get(9), row.get(10));
            data.add(stdoff);
            //System.out.println(stdoff.tostring());
            //System.out.println(row.get(0)+" "+row.get(1)+" "+row.get(2)+" "+row.get(3)+" "+row.get(4)+" "+row.get(9)+" "+row.get(10));
           // System.out.println(data);
        }

        //tableView.setEditable(true);
        //tableView.setItems(data);
        //data.get(0).setFirstName("Jacob2");

    }

    @FXML
    void signoutbuttonAction(ActionEvent event)
    {
        try{
            Node node = (Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));/* Exception */
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
            Parent root = FXMLLoader.load(getClass().getResource("Admin_Home.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin Home");
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
    
    @FXML
    public void refreshTable()
    {
        for (int i = 0; i < tableView.getColumns().size(); i++)
        {
            ((TableColumn) (tableView.getColumns().get(i))).setVisible(false);
            ((TableColumn) (tableView.getColumns().get(i))).setVisible(true);
        }
    }
    
}
