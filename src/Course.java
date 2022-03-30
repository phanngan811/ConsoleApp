import java.util.ArrayList;

public class Course{
    private String idCourse;
    private String nameCourse;
    private double noCredits;
    private ArrayList<Student> studentList;
    Course(String idCourse, String nameCourse,double noCredits ){
        this.idCourse=idCourse;
        this.nameCourse=nameCourse;
        this.noCredits =noCredits;
        this.studentList=new ArrayList<Student>();
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }


    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }


    public void setNoCredits(double noCredits) {
        this.noCredits = noCredits;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }


    public String getIdCourse() {
        return idCourse;
    }



    @Override
    public String toString() {
        return this.idCourse +"; " + this.nameCourse + "; "+this.noCredits+"; ";
    }

}
