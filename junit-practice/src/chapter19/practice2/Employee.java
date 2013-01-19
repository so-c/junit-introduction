package chapter19.practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Employee> load(InputStream input) throws IOException {
        List<Employee> result = new ArrayList<>();
        
        try (BufferedReader reader =
                new BufferedReader(new InputStreamReader(input))) {
            while (true) {
                String csvRecord = reader.readLine();
                if (csvRecord == null) {
                    break;
                }
                result.add(createInstance(csvRecord));
            }
        }

        return result;
    }

    private static Employee createInstance(String csvRecord) {
        String[] attributes = csvRecord.split(",");
        String firstName = attributes[0].trim();
        String lastName = attributes[1].trim();
        String email = attributes[2].trim();
        return new Employee(firstName, lastName, email);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [firstName=").append(firstName)
                .append(", lastName=").append(lastName).append(", email=")
                .append(email).append("]");
        return builder.toString();
    }
}
