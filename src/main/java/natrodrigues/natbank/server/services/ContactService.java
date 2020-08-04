package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.models.Contact;
import natrodrigues.natbank.server.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService implements Services<Contact> {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void verify(Contact contact) throws NatbankException {
        Optional<Account> optionalAccount = accountRepository.findByNumber(contact.getAccountNumber());
		if(optionalAccount.isPresent() == false) {
			throw new AccountException("account number",
				"Account number must be from an existing account");
		}
    }
}
