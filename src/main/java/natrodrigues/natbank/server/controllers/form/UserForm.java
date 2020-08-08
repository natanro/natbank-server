package natrodrigues.natbank.server.controllers.form;

import natrodrigues.natbank.server.models.User;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Email
    private String email;
    @NotEmpty
    @NotNull
    private String password;
    @CPF
    @NotEmpty
    @NotNull
    private String cpf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

	public User convert() {
        User user = new User();
        user.setCpf(this.cpf);
        user.setEmail(this.email);
        user.setName(this.name);
        user.setPassword(new BCryptPasswordEncoder(10).encode(this.password));
        return user;
	}
}
