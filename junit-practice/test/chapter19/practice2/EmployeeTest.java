package chapter19.practice2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

public class EmployeeTest {
    @Test
    public void loadでEmloyeeの一覧を取得できる() throws Exception {
        // SetUp
        InputStream input = getClass().getResourceAsStream("employee.txt");
        // Exercise
        List<Employee> actual = Employee.load(input);
        // Verify
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.size(), is(2));
        assertThat(actual.get(0).getFirstName(), is("Ichiro"));
        assertThat(actual.get(0).getLastName(), is("Tanaka"));
        assertThat(actual.get(0).getEmail(), is("ichiro@example.com"));
        assertThat(actual.get(1).getFirstName(), is("Hanako"));
        assertThat(actual.get(1).getLastName(), is("Suzuki"));
        assertThat(actual.get(1).getEmail(), is("hanako@example.com"));
    }
}
