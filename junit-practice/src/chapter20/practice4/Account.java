package chapter20.practice4;

public class Account {
    private String name;
    private String password;

    public Account(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Account [name=").append(name).append(", password=").append(password).append("]");
        return builder.toString();
    }
    
}
