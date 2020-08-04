package natrodrigues.natbank.server.models;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    private String name;
    private Long accountNumber;

    public Contact() {
    }

    public Contact(String name, Long accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
