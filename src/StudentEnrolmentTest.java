import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class StudentEnrolmentTest {
    public static StudentEnrolment se = new StudentEnrolment();
    InputStream sysInBackup = System.in;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadInfo() throws IOException {
        String expected = "The program is loading";
        String result = se.loadInfo();
        assertEquals(expected, result);
    }

    @Test
    public void viewAllData() throws IOException {
        loadInfo();
        String expected ="S101312; Alex Mike; 8/11/2001; COSC4030; Theory of Computation; 5; 2020C\n" +
                "S102732; Mark Duong; 8/28/2001; COSC4030; Theory of Computation; 5; 2020C\n" +
                "S103723; Hai Hoang Vu; 4/25/2000; BUS2232; Business Law; 3; 2020B\n" +
                "S103821; Son Minh Doan; 2/3/2000; PHYS1230; Introductory Human Physiology; 4; 2021A\n" +
                "S101163; Joseph Fergile; 5/9/1999; BUS2232; Business Law; 3; 2020C\n" +
                "S101153; Jang Min Seon; 9/25/2000; COSC3321; Artificial Intelligence; 3; 2021A\n" +
                "S103817; Thuy Thu Nguyen; 3/4/2000; COSC3321; Artificial Intelligence; 3; 2021A\n" +
                "S103912; Son Thanh Le; 2/9/2001; BUS2232; Business Law; 3; 2020C\n" +
                "S102192; Mark Patterson; 6/5/2000; PHYS1230; Introductory Human Physiology; 4; 2021A\n" +
                "S103192; Ngan Thu Vo; 3/9/1998; BUS2232; Business Law; 3; 2020B\n" +
                "S101312; Alex Mike; 8/11/2001; PHYS1230; Introductory Human Physiology; 4; 2021A\n" +
                "S103817; Thuy Thu Nguyen; 3/4/2000; COSC4030; Theory of Computation; 5; 2020C\n" +
                "S101163; Joseph Fergile; 5/9/1999; COSC3321; Artificial Intelligence; 3; 2021A\n" +
                "S102732; Mark Duong; 8/28/2001; COSC3321; Artificial Intelligence; 3; 2021A\n" +
                "S101312; Alex Mike; 8/11/2001; BUS2232; Business Law; 3; 2020C";

        //assertEquals(expected, se.viewAllData());



    }

    @Test
    public void studentEnroll() {
        String userInput = "s3863893";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayInputStream name = new ByteArrayInputStream("Phan Ngan".getBytes());
        System.setIn(name);
        ByteArrayInputStream birthdate = new ByteArrayInputStream("08/11/2001".getBytes());
        System.setIn(birthdate);
        ByteArrayInputStream idCourse = new ByteArrayInputStream("SOE123".getBytes());
        System.setIn(idCourse);
        ByteArrayInputStream nameCourse = new ByteArrayInputStream("JAVA PROGRAMMING".getBytes());
        System.setIn(nameCourse);
        ByteArrayInputStream noCredit = new ByteArrayInputStream("2".getBytes());
        System.setIn(noCredit);
        ByteArrayInputStream semester = new ByteArrayInputStream("2021A".getBytes());
        System.setIn(semester);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        String expected = "You have been successfully added to the course!";

        assertEquals(expected, se.studentEnroll());
// optionally, reset to its original
        System.setIn(sysInBackup);
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteEnroll() throws IOException {
        StudentEnrolment se = new StudentEnrolment();
        se.loadInfo();
        ByteArrayInputStream idStudent = new ByteArrayInputStream("S101312".getBytes());
        System.setIn(idStudent);

        String expected ="A student and a course  are deleted";
        assertEquals(expected,se.deleteEnroll());
        // optionally, reset to its original
        System.setIn(sysInBackup);
    }
}