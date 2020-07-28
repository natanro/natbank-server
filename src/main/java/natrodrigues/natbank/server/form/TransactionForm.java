package natrodrigues.natbank.server.form;

import javax.validation.constraints.NotNull;

import natrodrigues.natbank.server.models.Contact;
import natrodrigues.natbank.server.models.Transaction;

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

	public Transaction convert() {
        Transaction transaction = new Transaction(this.value, this.contact);
        transaction.setId(this.uuid);
        return transaction;
	}

	public AccountForm getAccountForm() {
		return this.accountForm;
    }
    
    public void setAccountForm(AccountForm accountForm) {
        this.accountForm = accountForm;
    }

}
