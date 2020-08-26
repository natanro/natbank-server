package natrodrigues.natbank.server.controllers.dto;

import natrodrigues.natbank.server.models.User;

public class UserDto {

    private String name;
    private String email;

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
