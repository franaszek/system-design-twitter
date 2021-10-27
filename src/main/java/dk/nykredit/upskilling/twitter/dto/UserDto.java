package dk.nykredit.upskilling.twitter.dto;

import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull(message = "name must not be empty")
    private String name;

    @NotNull
    private String password;

    private String picture;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", picture='" + picture + '\'' +
            '}';
    }
}
