package natrodrigues.natbank.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;
    @OneToOne(orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;
    
    private String name;
    private String email;
    private String password;
    private String cpf;

    public User() {
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

	public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "User {id: "+this.id+" name: "+this.name+" email: "+this.email+" cpf: "+this.cpf+"}";
    }
}