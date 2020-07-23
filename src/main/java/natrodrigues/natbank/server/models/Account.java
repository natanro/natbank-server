package natrodrigues.natbank.server.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import natrodrigues.natbank.server.repository.AccountMakerRepository;

@Entity
@Table(name = "account")
public class Account {

    @Id
    private Long id;
    private String agency;
    private Long number;
    private Double balance;
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Account() {
    }

    public Account(User user, AccountMakerRepository accountMakerRepository) {
        this.user = user;
        AccountMaker accountMaker = accountMakerRepository.findById(1L).get();
        this.number = accountMaker.getNumber();
        this.agency = accountMaker.getAgency();
        this.balance = 1000.0;
	}

	public String getAgency() {
        return agency;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public Long getId() {
		return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account {id: "+this.id+" agency: "+this.agency+" number: "+this.number+" balance: "+this.balance+"}";
    }
}
