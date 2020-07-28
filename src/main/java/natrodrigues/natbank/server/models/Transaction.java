package natrodrigues.natbank.server.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @Column(name = "transaction_id")
    private String id;

    @Embedded
    private Contact contact;
    private Double value;
    private LocalDateTime creationDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Transaction() {
    }

    public Transaction(Double value, Contact contact) {
        this.value = value;
        this.contact = contact;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public Double getValue() {
        return value;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

	public void setType(TransactionType type) {
        this.type = type;
    }
    
    public TransactionType getType() {
        return type;
    }

}