package dk.nykredit.upskilling.twitter.dto;

public class LoginDto {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
