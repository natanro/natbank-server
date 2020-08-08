package natrodrigues.natbank.server.controllers.dto;

public class TokenDto {
    private String token;
    private String type;

    public TokenDto(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }
}
