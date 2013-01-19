package chapter19.practice2;

import static matcher.EmployeeMatcher.*;
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

    @Test
    public void カスタムMatcherを使ったテスト() throws Exception {
        // SetUp
        InputStream input = getClass().getResourceAsStream("employee.txt");
        Employee expectedIchiro = new Employee("Ichiro", "Tanaka", "ichiro@example.com");
        Employee expectedHanako = new Employee("Hanako", "Suzuki", "hanako@example.com");
        // Exercise
        List<Employee> actual = Employee.load(input);
        // Verify
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.size(), is(2));
        assertThat(actual.get(0), is(employee(expectedIchiro)));
        assertThat(actual.get(1), is(employee(expectedHanako)));
    }
}
