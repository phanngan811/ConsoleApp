import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hi guys, welcome to my program, Thank you so much ");

        Scanner scanner = new Scanner(System.in);
        String choose = null;
        boolean exit = false;
        StudentEnrolment se = new StudentEnrolment();

        showEnrollment();
        while (true) {
            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    se.loadInfo();
                    break;
                case "2":
                    se.viewCourseEnrolled();
                    break;
                case "3":
                    se.studentEnroll();
                    break;
                case "4":
                    se.update();
                    break;
                case "5":
                    se.deleteEnroll();
                    break;
                case "6":
                    se.viewAllData();
                    break;
                case "7":
                    System.out.println("The program is quit");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input! ");
                    break;
            }
            if (exit) {
                break;
            }
            showEnrollment();
        }
    }
    public static void showEnrollment(){
        //System.out.println("Hi guys, welcome to my program, Thank you so much ");
        System.out.println("1. Loading the students and courses from file ");
        System.out.println("2. View all the courses that you enrolled");
        System.out.println("3. Student enrol the course");
        System.out.println("4. Update a Student and a course");
        System.out.println("5. Delete a Student and a course enrolled");
        System.out.println("6. View all the student and course");
        System.out.println("7. Quit programming ");
        System.out.print("Select a function (1-7): ");

    }

}
