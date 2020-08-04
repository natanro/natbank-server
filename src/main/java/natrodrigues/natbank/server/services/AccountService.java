package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.form.AccountForm;
import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

	public void verify(AccountForm accountForm) throws AccountException {
		Optional<Account> optionalAccount = accountRepository.findByNumber(accountForm.getNumber());
		if(optionalAccount.isPresent() == false) {
			throw new AccountException("account number",
			 "Account number must be from an existing account");
		}
		Account account = optionalAccount.get();
		if(account.getId() != accountForm.getId() || !account.getUser().getName().equals(accountForm.getName())) {
			throw new AccountException("account number",
					"Id or user name must be compatible with account informations");
		}
	}

	public void verify(Contact contact) throws AccountException {
		Optional<Account> optionalAccount = accountRepository.findByNumber(contact.getAccountNumber());
		if(optionalAccount.isPresent() == false) {
			throw new AccountException("account number",
				"Account number must be from an existing account");
		}
	}

}
