package natrodrigues.natbank.server.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.repository.AccountMakerRepository;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    private String agency;
    private Long number;
    private Double balance;
    @OneToOne(mappedBy = "account")
    private User user;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Transaction> transactions = new ArrayList<>();

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

	public void addTransaction(Transaction transaction, TransactionType type) throws AccountException {
        if(type == TransactionType.SEND) {
            sendTransaction(transaction, type);
        } else {
            recieveTransaction(transaction, type);
        }
	}

    private void recieveTransaction(Transaction transaction, TransactionType type) {
        this.balance += transaction.getValue();
        transaction.setType(type);
        transactions.add(transaction);
    }

    private void sendTransaction(Transaction transaction, TransactionType type) throws AccountException {
        if(this.balance < transaction.getValue()) {
            throw new AccountException("balance", "Transaction value must be less or equal to account's balance");
        }
        this.balance -= transaction.getValue();
        transaction.setType(type);
    }
}
