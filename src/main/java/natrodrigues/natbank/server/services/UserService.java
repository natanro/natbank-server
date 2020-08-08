package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.controllers.form.UserForm;
import natrodrigues.natbank.server.controllers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements Services<UserForm>{

    public static final String CPF = "Cpf";
    public static final String THIS_CPF_IS_ALREADY_IN_USE = "This cpf is already in use";
    @Autowired
    private UserRepository userRepository;

    @Override
    public void verify(UserForm userForm) throws NatbankException {
        if(userRepository.findByCpf(userForm.getCpf()).isPresent()) {
            throw new AccountException(CPF, THIS_CPF_IS_ALREADY_IN_USE);
        }
    }
}
