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
        se.studentEnroll();

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