package UH_Cntrl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller_student implements Initializable  {

    private ObservableList<Student> student_table_data;

   @Override
    public void initialize(URL location, ResourceBundle resources) {

       //Set cell values so table can properly populate

       col_name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
       col_age.setCellValueFactory(new PropertyValueFactory<Student,Integer>("age"));
       col_gpa.setCellValueFactory(new PropertyValueFactory<Student,Float>("gpa"));
       col_major.setCellValueFactory(new PropertyValueFactory<Student,String>("major"));

        populateTable();
    }


    @FXML
    public TableColumn col_name, col_age, col_gpa, col_major;
    public TableView student_tableview;





    //Connect to SQLite DB
    private Connection connect() {
        String url = "jdbc:sqlite:Assigments\\src\\UH_Cntrl\\Student_DB.db";
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
        String sql = "SELECT * FROM Students";
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet result_set = stmt.executeQuery(sql); //
                while (result_set.next()) {
                    student_table_data.add(new Student(result_set.getString(1), result_set.getInt(2)
                            , result_set.getFloat(3), result_set.getString(4)));
                }
                student_tableview.setItems(student_table_data);


                conn.close();
            } catch (SQLException tableQueryException) {
                System.err.println(tableQueryException.toString());
            }
            System.out.println("ok");
        }
    }
}
