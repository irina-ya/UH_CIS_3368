package UH_Cntrl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller_student implements Initializable {

    private ObservableList<Student> student_table_data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTable();
    }


    @FXML
    //public TableColumn col_name, col_age, col_gpa, col_major;
    public TableView student_tableview;





    //Connect to SQLite DB
    private Connection connect() {
        String url = "jdbc:sqlite:Assigments/UH_Cntrl/Students_DB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            System.out.println("Irina - you should have remembered this processes better :(");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void populateTable() {
        student_table_data = FXCollections.observableArrayList();

        Connection conn = this.connect();
        String sql_main = "SELECT * FROM Students ORDER BY Age";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql_main);
            ResultSet result_set = preparedStatement.executeQuery();
            while (result_set.next()) {
                student_table_data.add(new Student(result_set.getString(1),result_set.getInt(2)
                , result_set.getString(3),result_set.getFloat(4)));
            }
            student_tableview.setItems(student_table_data);

            result_set.close();
            conn.close();
        } catch (SQLException tableQueryException) {
            System.err.println(tableQueryException.toString());
        }
    }

}
