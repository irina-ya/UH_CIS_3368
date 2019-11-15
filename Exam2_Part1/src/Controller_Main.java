import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


import java.awt.*;

public class Controller_Main {
    public static ObservableList<Car> Cars = FXCollections.observableArrayList();

    @FXML
    public ListView<Car> CarList;

    @FXML
    public Button add;

    @FXML
    public Button drive;
    @FXML
    public Button remove;
    public Label print;



    public void AddButton_Click(){
        int counter = 0;
        Car newCar = new Car();
        newCar.car_name = "Car" + counter+1;
        Cars.add(newCar);
        CarList.setItems(Cars);
    }

    public void DriveClick(){

    }



}
