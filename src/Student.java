import java.util.ArrayList;

public class Student {
    private String idStudent;
    private String name;
    private String birthdate;
    private ArrayList<Course> courseList;
    Student(String idStudent, String name,String birthdate ){
        this.idStudent = idStudent;
        this.name = name;
        this.birthdate = birthdate;
        this.courseList=new ArrayList<Course>();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String toString() {
        return this.idStudent +"; "+this.name + "; "+this.birthdate+";";
    }


}
