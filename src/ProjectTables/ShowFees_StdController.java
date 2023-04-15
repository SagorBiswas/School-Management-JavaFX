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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SAGOR
 */
public class ShowFees_StdController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView tableView;
    @FXML 
    private Button backbtn;
    @FXML 
    private Button loadbtn;
    @FXML
    private Button SignOutbtn;
    @FXML
    private Button Extbtn;
    
    @FXML private TextField std;
    @FXML private Text txt1;
    
    @FXML TableColumn<Fee,String>FEE_ID;
    @FXML TableColumn<Fee,String>FEE_DESCRIPTION;
    @FXML TableColumn<Fee,String>FEE_AMOUNT;
    @FXML TableColumn<Fee,String>LAST_PAYMENT_DATE;
    
    final ObservableList<Fee> data = FXCollections.observableArrayList();
    private boolean test = false ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FEE_ID.setCellValueFactory(new PropertyValueFactory<Fee,String>("FEE_ID"));
        FEE_DESCRIPTION.setCellValueFactory(new PropertyValueFactory<Fee,String>("FEE_DESCRIPTION"));
        FEE_AMOUNT.setCellValueFactory(new PropertyValueFactory<Fee,String>("FEE_AMOUNT"));
        LAST_PAYMENT_DATE.setCellValueFactory(new PropertyValueFactory<Fee,String>("LAST_PAYMENT_DATE"));
        
        tableView.setItems(data);
    }  
    
    public void refreshTable()
    {
        for (int i = 0; i < tableView.getColumns().size(); i++)
        {
            ((TableColumn) (tableView.getColumns().get(i))).setVisible(false);
            ((TableColumn) (tableView.getColumns().get(i))).setVisible(true);
        }
    }
    
    public void load()
    {
        System.out.println("Load Called");
        //refreshTable();
        data.clear();
        String std_id = std.getText();
        List<List<String>> FeeList = new Fees_Std().getAllFees(std_id);
        for (List<String> row : FeeList)
        {
            Fee fee = new Fee(row.get(0), row.get(1), row.get(2), row.get(3));
            System.out.println(fee.toString());
            data.add(fee);
        }

    }

    
    public void load2(String std_id )
    {
        
        System.out.println("Load 2 Called");
        //refreshTable();
        data.clear();
        
        List<List<String>> FeeList = new Fees_Std().getAllFees(std_id);
        for (List<String> row : FeeList)
        {
            Fee fee = new Fee(row.get(0), row.get(1), row.get(2), row.get(3));
            System.out.println(fee.toString());
            data.add(fee);
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
            Parent root = FXMLLoader.load(getClass().getResource("Student_Home01.fxml"));/* Exception */
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
