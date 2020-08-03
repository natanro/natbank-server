package natrodrigues.natbank.server.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.models.Contact;
import natrodrigues.natbank.server.repository.AccountRepository;

public class AccountForm {

    @NotNull
    private Long id;
    @NotNull
    private Long number;
    @NotNull
    private String name;

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

	public Account convert(AccountRepository accountRepository) {
        Optional<Account> account = accountRepository.findByNumber(this.number);
        if(account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
	}

	public Contact toContact() {
		return new Contact(this.name, this.number);
	}
}
