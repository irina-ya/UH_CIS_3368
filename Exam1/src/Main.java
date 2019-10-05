import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("AddNumbers.fxml"));
        primaryStage.setTitle("Get the sum!");
        primaryStage.setScene(new Scene(root, 550, 275));
        primaryStage.show();
    }

}