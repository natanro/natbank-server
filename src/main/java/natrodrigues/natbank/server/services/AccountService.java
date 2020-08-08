package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.controllers.form.AccountForm;
import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.controllers.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements Services<AccountForm> {

	public static final String ACCOUNT_NUMBER = "account number";
	public static final String ACCOUNT_NUMBER_MUST_BE_FROM_AN_EXISTING_ACCOUNT =
			"Account number must be from an existing account";
	public static final String ID_OR_USER_NAME_MUST_BE_COMPATIBLE_WITH_ACCOUNT_INFORMATION =
			"Id or user name must be compatible with account information";
	@Autowired
    private AccountRepository accountRepository;

	@Override
	public void verify(AccountForm accountForm) throws NatbankException {
		Optional<Account> optionalAccount = accountRepository.findByNumber(accountForm.getNumber());
		if(optionalAccount.isEmpty()) {
			throw new AccountException(ACCOUNT_NUMBER,
					ACCOUNT_NUMBER_MUST_BE_FROM_AN_EXISTING_ACCOUNT);
		}
		Account account = optionalAccount.get();
		if(account.getId() != accountForm.getId() ||
				!account.getUser().getName().equals(accountForm.getName())) {
			throw new AccountException(ACCOUNT_NUMBER,
					ID_OR_USER_NAME_MUST_BE_COMPATIBLE_WITH_ACCOUNT_INFORMATION);
		}
	}
}
