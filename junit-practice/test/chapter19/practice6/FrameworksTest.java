package chapter19.practice6;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class FrameworksTest {
    @DataPoints
    public static ApplicationServer[] APP_SERVER_PARAMS = ApplicationServer.values();
    
    @DataPoints
    public static Database[] DATABASE_PARAMS = Database.values();
    
    @Test
    public void testIsSupport() throws Exception {
        // SetUp
        // Exercise
        boolean actual = Frameworks.isSupport(ApplicationServer.Tomcat, Database.MySQL);
        // Verify
        assertThat(actual,is(true));
    }

}
