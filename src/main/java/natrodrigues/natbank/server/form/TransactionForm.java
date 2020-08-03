package natrodrigues.natbank.server.form;

import javax.validation.constraints.NotNull;

import natrodrigues.natbank.server.models.Contact;
import natrodrigues.natbank.server.models.Transaction;
import natrodrigues.natbank.server.models.TransactionId;
import natrodrigues.natbank.server.models.TransactionType;

public class TransactionForm {

    @NotNull
    private String uuid;
    @NotNull
    private Contact contact;
    @NotNull
    private Double value;
    @NotNull
    private AccountForm accountForm;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public Transaction convert(TransactionType type) {
        Transaction transaction = new Transaction(this.value, this.contact);
        transaction.setId(new TransactionId(this.uuid, type));
        transaction.setReciever(this.contact);
        return transaction;
	}

	public AccountForm getAccountForm() {
		return this.accountForm;
    }
    
    public void setAccountForm(AccountForm accountForm) {
        this.accountForm = accountForm;
    }

}
