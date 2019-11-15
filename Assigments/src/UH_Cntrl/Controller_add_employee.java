package UH_Cntrl;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.Random;

import javafx.scene.control.Alert.AlertType;

//Alert tutorial from - https://o7planning.org/en/11529/javafx-alert-dialogs-tutorial

import javafx.stage.Stage;

public class Controller_add_employee {

    @FXML

    public ChoiceBox TypeBox;
    public ChoiceBox LvlBox;

    public static ObservableList<UHEmployee> employeeList = FXCollections.observableArrayList();

    public ListView<UHEmployee> employeeListView;

    public Button Cancel;
    public Button Submit;
    public TextField Name;
    public TextField Dept;

    Random rnd = new Random();

    @FXML public void Cancel_Click(){
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.hide();}


    @FXML
    public void Submit_Click() {

        String employee_name = Name.getText();
        String employee_dept = Dept.getText();
        String employee_type = String.valueOf(TypeBox.getValue());
        String employee_access_lvl = String.valueOf(LvlBox.getValue());



        //FXMLLoader loader = new FXMLLoader(Main.class.getResource("Main_fxml.fxml"));
        //Parent sceneFXML = loader.load();
        //Controller ctrl = (loader.getController());


        //Set up alert checks for employee entry
        //Alert tutorial from - https://o7planning.org/en/11529/javafx-alert-dialogs-tutorial
        if (employee_name.equals("") | TypeBox.getValue() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Cannot add employee!");
            alert.setContentText("Fill out required fields!");
            alert.showAndWait();
        } else {
            if (employee_type.equals("Faculty")){
                if (employee_dept.equals("")) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Cannot add new faculty!");
                    alert.setContentText("Please enter a department!");
                    alert.showAndWait();
                } else {
                    Faculty newFaculty = new Faculty();
                    newFaculty.id = rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100);
                    newFaculty.name = employee_name;
                    newFaculty.type = employee_type;
                    newFaculty.department = employee_dept;
                    newFaculty.hire();
                    employeeList.add(newFaculty);
                    employeeListView.setItems(employeeList);

                    }

            } else if (employee_type.equals("Staff")) {
                    if (LvlBox.getValue() == null) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("Cannot add new staff!");
                        alert.setContentText("Please enter an access level!");
                        alert.showAndWait();
                    } else {
                        Staff newStaff = new Staff();
                        newStaff.id = rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100);
                        newStaff.name = employee_name;
                        newStaff.type = employee_type;
                        newStaff.accessLevel = Integer.parseInt(employee_access_lvl);
                        newStaff.hire();
                        employeeList.add(newStaff);
                        employeeListView.setItems(employeeList);

                    }
                }
            }
        }



    @FXML
    //Populate the Employee type choice box
    public void EmployeeType_Select(){
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Faculty", "Staff");
        TypeBox.setItems(list);
    }

    @FXML
    //Populate access lvl box
    public void Access_Lvl(){
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("1", "2","3","4","5","6","7","8","9","10");
        LvlBox.setItems(list);
    }

    @FXML
    public void DeleteButton_Click() {

        if (employeeListView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("No user is selected.");
            alert.setContentText("Please select a user.");
            alert.showAndWait();
        } else
            employeeList.remove(employeeListView.getSelectionModel().getSelectedItem());
        employeeListView.setItems(employeeList);

    }

    }


