import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
public class StudentEnrolment implements StudentEnrolmentManager {
    //attribute for StudentEnrolment
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<String> semesterList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    //Dependency injection with constructor
    StudentEnrolment(ArrayList<String> semester) {
        this.semesterList = semester;
        this.studentList = new ArrayList<Student>();
        this.courseList = new ArrayList<Course>();
    }

    public StudentEnrolment() {{
    }
    }


    //Try to load the Info file
    public String line;

    public String loadInfo() throws IOException {
        semesterList = new ArrayList<>();
        studentList = new ArrayList<Student>();
        courseList = new ArrayList<Course>();

        try (
                // creating file name
                InputStream fileInputStream = new FileInputStream("Info.csv");
                InputStreamReader reader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(reader);
        ) {

            // Split the line of each information
            while ((line = br.readLine()) != null) {
                String[] objects = line.split(";");
                String idStudent = objects[0];
                String name = objects[1];
                String birthdate = objects[2];
                String idCourse = objects[3];
                String nameCourse = objects[4];
                double noCredits = Double.parseDouble(objects[5]);
                String semester = objects[6];
                //create student info to add in this file
                studentList.add(new Student(idStudent, name, birthdate));
                //create course info to add in this file
                courseList.add(new Course(idCourse, nameCourse, noCredits));
                semesterList.add(semester);
            }
            System.out.println("The program is loading");
        }
        return "The program is loading";
    }

    //view all student and course
    @Override
    public void viewAllData() {
        //condition for checking all ArrayList == 0
        if (studentList.size() == 0 && courseList.size() == 0 && semesterList.size() == 0)
            System.out.println("Please select number 1 before select this one");
        else {
            //If they are != 0 -> print all data
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println(studentList.get(i) + "" + courseList.get(i) + semesterList.get(i));

            }
        }
    }

    //Student enroll course
    @Override
    public double studentEnroll() {

        //taking info from student
        System.out.println("Enter your ID: ");
        String idStudent = sc.nextLine();
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your Date of Birth: ");
        String birthdate = sc.nextLine();
        // creating student from input of user
        Student stu = new Student(idStudent, name, birthdate);
        //adding all input of user into Info.csv file
        studentList.add(stu);

        //taking info from course
        System.out.println("Enter the course ID: ");
        String idCourse = sc.nextLine();
        System.out.println("Enter the course name: ");
        String nameCourse = sc.nextLine();
        System.out.println("Enter the number credits of this course: ");
        double noCredits = Double.parseDouble(sc.nextLine());
        // creating course from input of user
        Course course = new Course(idCourse, nameCourse, noCredits);
        //adding all input of user into Info.csv file
        courseList.add(course);

        //taking info from semester
        System.out.println("Enter the semester: ");
        String semester = sc.nextLine();
        semesterList.add(semester);

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIdStudent().contains(idStudent) && courseList.get(i).getIdCourse().contains( idCourse)) {
                courseList.get(i).setStudentList(studentList);
                System.out.println("You have been successfully added to the course!");
                System.out.println("Select number 6 to see your info enrolled");
            }
        }

        return noCredits;
    }

    // enter the id o confirm to update or delete
    public String enterIdStudent() {
        // get all data from file
        for (int i = 0; i < studentList.size(); i++)
            System.out.println(studentList.get(i).toString() + courseList.get(i).toString() + semesterList.get(i));

        // input idStudent to check data
        System.out.print("Enter the Student ID: ");
        while (true) {
            try {
                String idStudent = sc.nextLine();
                return idStudent;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid ID");
            }
        }
    }


    //update info student, course
    @Override
    public int update() {
        // enter idStudent to check that account exist
        String idStudent = enterIdStudent();
        for (int i = 0; i < studentList.size(); i++) {
            //check input exits in data
            if (studentList.get(i).getIdStudent().equals(idStudent)) {
                System.out.println("The program is editing");
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                studentList.get(i).setName(name);
                System.out.println("Enter your Date of Birth: ");
                String birthdate = sc.nextLine();
                studentList.get(i).setBirthdate(birthdate);

                System.out.println("Enter ID course name: ");
                String idCourse = sc.nextLine();
                courseList.get(i).setIdCourse(idCourse);
                System.out.println("Enter Course name: ");
                String nameCourse = sc.nextLine();
                courseList.get(i).setNameCourse(nameCourse);
                System.out.println("Enter number of credits: ");
                double noCredits = Double.parseDouble(sc.nextLine());
                courseList.get(i).setNoCredits(noCredits);

                System.out.println("Enter the semester: ");
                String semester = sc.nextLine();
                semesterList.set(4, semester);
                System.out.println("Successful update");

                System.out.println("Please select number 6 to view a new info");
                return 1;
            }
        }
        System.out.println("Please enter correctly ID");
        return 0;
    }


    //delete the enrollment
    @Override
    public int deleteEnroll() {
        //// enter idStudent to check that account exist
        String idStudent = enterIdStudent();
        //remove data
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIdStudent().equals(idStudent)) {
                //remove base on studentList.get(i)
                studentList.remove(studentList.get(i));
                System.out.println("A student and a course  are deleted");
                System.out.println("Select number 6 to see your info deleted");
                return 1;
            }
        }

        //The case that contact user input is not existed to delete
        System.out.println("Please enter correctly ID");
        return 0;
    }

    @Override
    public void viewCourseEnrolled() {
        System.out.print("Enter student ID to see the course enrolled: ");
        String idStudent = sc.nextLine();
        boolean checkIdAndCourse = false;
        for (int i = 0; i < studentList.size(); i++) {
            if ((studentList.get(i).getIdStudent().contains(idStudent)) ) {
                checkIdAndCourse =true;
                System.out.println(semesterList.get(i)+": "+ courseList.get(i).toString().replaceAll(";"," "));
            }
        }
        if (!checkIdAndCourse) {
            System.out.println("Please enter correctly student ID and semester");
        }
    }
}