package natrodrigues.natbank.server.controllers.form;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;

public class UserCredentialForm {
    @NotNull
    @CPF
    private String cpf;
    @NotNull
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
