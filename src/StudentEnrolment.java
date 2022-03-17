import java.util.ArrayList;
public class StudentEnrolment {
    private ArrayList<Student> studentList;
    private ArrayList<Course> courseList;
    private String semester;
    StudentEnrolment(String semester){
        this.semester = semester;
        this.studentList= new ArrayList<Student>();
        this.courseList = new ArrayList<Course>();

    }

}
