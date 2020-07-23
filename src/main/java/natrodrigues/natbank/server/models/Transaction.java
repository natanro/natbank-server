package natrodrigues.natbank.server.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Embedded
    private Contact contact;
    private Double value;
    private LocalDateTime creationDate = LocalDateTime.now();

    public Transaction(Double value, Contact contact) {
        this.value = value;
        this.contact = contact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

}