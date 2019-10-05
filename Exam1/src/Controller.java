import com.sun.corba.se.impl.orb.ParserTable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class Controller {
    @FXML
    public Button Button;
    public Label LabelSum;
    public TextField FirstNumber;
    public TextField SecondNumber;

    @FXML
    public void Sum(){
        int fnumber = Integer.parseInt(FirstNumber.getText());
        int snumber = Integer.parseInt(SecondNumber.getText());

        int sum = fnumber + snumber;
        String printsum = Integer.toString(sum);

        LabelSum.setText(printsum);

    }



}
