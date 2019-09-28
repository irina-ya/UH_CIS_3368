package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<UHEmployee> employeeListView;

    private ObservableList<UHEmployee> employeeList = FXCollections.observableArrayList();

    @FXML
    public Button AddButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        employeeList = FXCollections.observableArrayList();
        generateEmployees();
        employeeListView.setItems(employeeList);

    }

    @FXML
    public void AddButton_Click() throws IOException {
        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("add_employee.fxml"));
        secondaryStage.setTitle("Add Employees");
        secondaryStage.setScene(new Scene(root, 345, 400));
        secondaryStage.show();
    }

    private void generateEmployees() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Staff newStaff = new Staff();
                newStaff.id = i;
                newStaff.name = "Staff " + i;
                newStaff.hire();
                employeeList.add(newStaff);
            } else {
                Faculty newFaculty = new Faculty();
                newFaculty.id = i;
                newFaculty.name = "Faculty " + i;
                newFaculty.hire();
                employeeList.add(newFaculty);
            }


        }

    }
}
