import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class StudentEnrolmentTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadInfo() throws IOException {
        String expected = "The program is loading";
        StudentEnrolment se = new StudentEnrolment();
        String result = se.loadInfo();
        assertEquals(expected, result);
    }

    @Test
    public void viewAllData() throws IOException {
        loadInfo();
        String expected ="S101312; Alex Mike; 12/12/1999; COSC4030; Theory of Computation; 5; 2020C\n" ;



    }

    @Test
    public void studentEnroll() {
        StudentEnrolment se= new StudentEnrolment();

    }




    @Test
    public void update() {
    }

    @Test
    public void deleteEnroll() throws IOException {
        StudentEnrolment se = new StudentEnrolment();
        se.loadInfo();
        se.enterIdStudent().contentEquals("1222");
        assertEquals("Remove 1 Info from data",se.loadInfo(),se.deleteEnroll());
    }
}