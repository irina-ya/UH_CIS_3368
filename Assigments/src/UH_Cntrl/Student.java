package UH_Cntrl;

import javafx.beans.property.*;

public class Student {
    //public String name;
    //public int age;
    //public float GPA;
    //public String major;


    public StringProperty nameProperty() {return name;}
    public IntegerProperty ageProperty() {return age;}
    public FloatProperty gpaProperty() {return GPA;}
    public StringProperty majorProperty() {return major;}


    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();
    private final StringProperty major = new SimpleStringProperty();
    private final FloatProperty GPA = new SimpleFloatProperty();

    public Student(String name1, int age1, String major1, float gpa1) {
        name.set(name1);
        age.set(age1);
        GPA.set(gpa1);
        major.set(major1);
    }
    public String getName() {return name.get();}
    public int getAge() {return age.get();}
    public String getMajor() {return major.get();}
    public double getGPA() {return GPA.get();}


    public void setName(String name1){ name.set(name1);}
    public void setAge(int age1){age.set(age1);}
    public void setMajor(String major1){major.set(major1);}
    public void setGPA(float gpa1){GPA.set(gpa1);}


}
