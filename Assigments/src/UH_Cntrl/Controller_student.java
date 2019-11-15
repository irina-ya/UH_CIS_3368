package UH_Cntrl;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
       pop_majors ();


    }


    @FXML
    public TableColumn col_name, col_age, col_gpa, col_major;
    public TableView student_tableview;
    public ComboBox major_filter;
    public JFXTextField gpa1, gpa2, age1, age2;


    //Connect to SQLite DB
    private Connection connect() {
        String url = "jdbc:sqlite:Assigments\\src\\UH_Cntrl\\Student_DB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            System.out.println("You should have remembered this processes better :(");
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
                ResultSet result_set = stmt.executeQuery(sql);
                while (result_set.next()) {
                    student_table_data.add(new Student(result_set.getString(1), result_set.getInt(2)
                            , result_set.getFloat(3), result_set.getString(4)));
                }
                student_tableview.setItems(student_table_data);
                conn.close();
            } catch (SQLException tableQueryException) {
                System.err.println(tableQueryException.toString());
            }
        }
    }

    public void pop_majors () {
        //Set Major ComboBox from DB
        Connection conn = this.connect();
        ObservableList<String> majors_list = FXCollections.observableArrayList();
        String sql = "SELECT DISTINCT Major FROM Students";
        majors_list.add("All");

        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet result_set = stmt.executeQuery(sql);
                while (result_set.next()) {
                    String M = (result_set.getString("Major"));
                    majors_list.add(M);
                }

                major_filter.setItems(majors_list);
                System.out.println(majors_list);

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void filter_majors (){
        Connection conn = this.connect();
        student_table_data = FXCollections.observableArrayList();
        String F_major = String.valueOf(major_filter.getValue());
        String sql = "SELECT * FROM Students WHERE Major = " + "'" + F_major + "'";

        if (major_filter.getValue() == "All") {
            populateTable();
        } //Resets major filter

        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet result_set = stmt.executeQuery(sql);
                while (result_set.next()) {
                    student_table_data.add(new Student(result_set.getString(1), result_set.getInt(2)
                            , result_set.getFloat(3), result_set.getString(4)));
                }
                student_tableview.setItems(student_table_data);
                conn.close();
            } catch (SQLException tableQueryException) {
                System.err.println(tableQueryException.toString());
            }
        }
    }



    public void filter_age () {
        student_table_data = FXCollections.observableArrayList();

        int age_from = Integer.parseInt(String.valueOf(age1.getText()));
        int age_to = Integer.parseInt(String.valueOf(age2.getText()));

        Connection conn = this.connect();
        String sql = "SELECT * FROM students WHERE age >= " + age_from + " AND age <= " + age_to;
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
        }
    }

    public void filter_gpa () {
        student_table_data = FXCollections.observableArrayList();

        int gpa_from = Integer.parseInt(String.valueOf(gpa1.getText()));
        int gpa_to = Integer.parseInt(String.valueOf(gpa2.getText()));

        Connection conn = this.connect();
        String sql = "SELECT * FROM Students WHERE gpa >= " + gpa_from + " AND gpa <= " + gpa_to;
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
        }
    }


}
