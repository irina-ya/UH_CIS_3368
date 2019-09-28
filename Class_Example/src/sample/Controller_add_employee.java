package sample;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller_add_employee {

    @FXML
    public ObservableList<UHEmployee> employeeList = FXCollections.observableArrayList();

    public ChoiceBox TypeBox;
    public ChoiceBox LvlBox;

    public Button Cancel;
    public Button Submit;
    public TextField Name;
    public TextField Dept;

    @FXML public void Cancel_Click(){
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.hide();}

    @FXML
    public void Submit_Click(){
        String employee_name = Name.getText();
        String employee_dept = Dept.getText();
        String employee_type = String.valueOf(TypeBox.getValue());
        String employee_access_lvl = String.valueOf(LvlBox.getValue());

        //System.out.println(employee_access_lvl + " " + employee_dept + " " + employee_name + " " + employee_type);

        if (employee_name.equals("") | employee_type == null){

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

    }


