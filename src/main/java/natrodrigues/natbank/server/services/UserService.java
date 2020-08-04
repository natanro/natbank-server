package natrodrigues.natbank.server.services;

import natrodrigues.natbank.server.config.exception.AccountException;
import natrodrigues.natbank.server.form.UserForm;
import natrodrigues.natbank.server.models.User;
import natrodrigues.natbank.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void verify(UserForm userForm) throws AccountException {
        if(userRepository.findByCpf(userForm.getCpf()).isPresent()) {
            throw new AccountException("Cpf", "This cpf is already in use");
        }
    }
}
