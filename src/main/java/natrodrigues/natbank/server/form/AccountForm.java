package natrodrigues.natbank.server.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.repository.AccountRepository;

public class AccountForm {

    @NotNull
    private Long id;
    @NotNull
    private Long number;

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

	public Account convert(AccountRepository accountRepository) {
        Optional<Account> account = accountRepository.findByNumber(this.number);
        if(account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
	}
}
