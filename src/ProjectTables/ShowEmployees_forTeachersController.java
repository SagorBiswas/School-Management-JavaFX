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
 * @author User
 */
public class ShowEmployees_forTeachersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 




    */
    
     @FXML private TableView tableView;
    
    @FXML private Button backbtn;
    @FXML private Button SignOutbtn;
    @FXML private Button Loadbtn;
    @FXML private Button exitbtn;
    
    @FXML TableColumn<Employee_Off,String>EMPLOYEE_ID;
    @FXML TableColumn<Employee_Off,String>FIRST_NAME;
    @FXML TableColumn<Employee_Off,String>LAST_NAME;
    @FXML TableColumn<Employee_Off,String>JOB_TITLE;
    @FXML TableColumn<Employee_Off,String>JOIN_DATE;
    @FXML TableColumn<Employee_Off,String>BIRTH_DATE;
 //   @FXML TableColumn<Employee_Off,String>SALARY;
    @FXML TableColumn<Employee_Off,String>BLOOD_GROUP;
    
    ObservableList<Employee_Off> data = FXCollections.observableArrayList();;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EMPLOYEE_ID.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("EMPLOYEE_ID"));
        FIRST_NAME.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("FIRST_NAME"));
        LAST_NAME.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("LAST_NAME"));
        JOB_TITLE.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("JOB_TITLE"));
        JOIN_DATE.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("JOIN_DATE"));
        BIRTH_DATE.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("BIRTH_DATE"));
      //  SALARY.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("SALARY"));
        BLOOD_GROUP.setCellValueFactory(new PropertyValueFactory<Employee_Off,String>("BLOOD_GROUP"));
        
        tableView.setItems(data);
    }   
    
    public void load()
    {
        data.clear();

        List<List<String>> TeacherDataList = new Employees_Off().getAllEmployees();
        for (List<String> row : TeacherDataList)
        {
            data.add(new Employee_Off(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6)));
        }
        tableView.setEditable(true);
        tableView.setItems(data);

    }
    
    public void load2(String Attribute, String Value)
    {
        data.clear();

        List<List<String>> TeacherDataList = new Employees_Off().getSomeEmployees(Attribute, Value);
        for (List<String> row : TeacherDataList)
        {
            data.add(new Employee_Off(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6)));
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


