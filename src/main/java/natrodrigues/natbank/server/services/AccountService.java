package natrodrigues.natbank.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

	public void verify(Long accountNumber) throws AccountException {
		if(accountRepository.findByNumber(accountNumber).isPresent() == false) {
			throw new AccountException("account number",
			 "Account number must be from an existing account");
		}
	}

}
