package natrodrigues.natbank.server.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    
    @EmbeddedId
    @Column(name = "transaction_id")
    private TransactionId id;

    @Embedded
    private Contact contact;

    private Double value;
    private LocalDateTime creationDate = LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(Double value, Contact contact) {
        this.value = value;
        this.contact = contact;
    }

    public TransactionId getId() {
        return id;
    }

    public void setId(TransactionId id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Double getValue() {
        return value;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

	public void setType(TransactionType type) {
        id.setType(type);
    }

}