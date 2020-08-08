package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.models.Contact;
import natrodrigues.natbank.server.controllers.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService implements Services<Contact> {
    public static final String ACCOUNT_NUMBER = "account number";
    public static final String ACCOUNT_NUMBER_MUST_BE_FROM_AN_EXISTING_ACCOUNT =
            "Account number must be from an existing account";
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void verify(Contact contact) throws NatbankException {
        Optional<Account> optionalAccount = accountRepository.findByNumber(contact.getAccountNumber());
		if(optionalAccount.isEmpty()) {
			throw new AccountException(ACCOUNT_NUMBER,
                    ACCOUNT_NUMBER_MUST_BE_FROM_AN_EXISTING_ACCOUNT);
		}
    }
}
