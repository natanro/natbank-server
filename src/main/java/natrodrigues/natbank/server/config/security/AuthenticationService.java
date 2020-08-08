package natrodrigues.natbank.server.config.security;

import natrodrigues.natbank.server.controllers.repository.UserRepository;
import natrodrigues.natbank.server.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    public static final String INVALID_USER_CREDENTIALS = "Invalid user credentials";
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByCpf(cpf);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new UsernameNotFoundException(INVALID_USER_CREDENTIALS);
    }
}
