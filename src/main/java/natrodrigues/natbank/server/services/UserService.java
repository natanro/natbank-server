package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.form.UserForm;
import natrodrigues.natbank.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements Services<UserForm>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void verify(UserForm userForm) throws NatbankException {
        if(userRepository.findByCpf(userForm.getCpf()).isPresent()) {
            throw new AccountException("Cpf", "This cpf is already in use");
        }
    }
}
