package natrodrigues.natbank.server.models;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    private String nome;
    private Long accountNumber;

    public Contact(String nome, Long accountNumber) {
        this.nome = nome;
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
}
