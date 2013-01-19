package matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import chapter19.practice2.Employee;

public class EmployeeMatcher extends BaseMatcher<Employee> {
    private final Employee expected;
    private String field;
    private Object expectedValue;
    private Object actualValue;

    public static Matcher<Employee> employee(Employee expected) {
        return new EmployeeMatcher(expected);
    }

    EmployeeMatcher(Employee expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {
        if (this.expected == null) {
            return actual == null;
        }

        if (!(actual instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) actual;

        if (notEquals(expected.getFirstName(), other.getFirstName())) {
            this.field = "firstName";
            this.expectedValue = expected.getFirstName();
            this.actualValue = other.getFirstName();
            return false;
        }
        if (notEquals(expected.getLastName(), other.getLastName())) {
            this.field = "lastName";
            this.expectedValue = expected.getLastName();
            this.actualValue = other.getLastName();
            return false;
        }
        if (notEquals(expected.getEmail(), other.getEmail())) {
            this.field = "email";
            this.expectedValue = expected.getEmail();
            this.actualValue = other.getEmail();
            return false;
        }

        return true;
    }

    private boolean notEquals(Object object, Object other) {
        if (object == null) {
            return (other == null);
        }
        return !object.equals(other);
    }

    @Override
    public void describeTo(Description description) {
        if (expected == null || field == null) {
            description.appendValue(expected);
        } else {
            description.appendText(field + "=")
                       .appendValue(expectedValue)
                       .appendText(", but ")
                       .appendValue(actualValue);
        }
    }
}
