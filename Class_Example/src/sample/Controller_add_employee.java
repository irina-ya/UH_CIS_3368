package sample;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Controller_add_employee {

    @FXML
    public ChoiceBox TypeBox;
    public ChoiceBox LvlBox;

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


