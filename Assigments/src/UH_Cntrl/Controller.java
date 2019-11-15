package UH_Cntrl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    //public ListView<UHEmployee> employeeListView;

    public JFXButton employeeButton;

    public JFXButton studentbutton;

    @FXML
    public void Employee_Click() throws IOException {
        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("add_employee.fxml"));
        secondaryStage.setTitle("Add Employees");
        secondaryStage.setScene(new Scene(root, 345, 400));
        secondaryStage.show();
        //employeeListView.setItems(shared_variables.employeeList);
    }

    @FXML
    public void Student_Click() throws IOException {
        Stage studentStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Students_fxml.fxml"));
        studentStage.setTitle("View Students");
        studentStage.setScene(new Scene(root, 1000, 600));
        studentStage.show();
    }

}






