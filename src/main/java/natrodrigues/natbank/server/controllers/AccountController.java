package natrodrigues.natbank.server.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.controllers.form.UserCredentialForm;
import natrodrigues.natbank.server.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import natrodrigues.natbank.server.controllers.dto.AccountDto;
import natrodrigues.natbank.server.controllers.form.UserForm;
import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.models.AccountMaker;
import natrodrigues.natbank.server.models.User;
import natrodrigues.natbank.server.controllers.repository.AccountMakerRepository;
import natrodrigues.natbank.server.controllers.repository.AccountRepository;
import natrodrigues.natbank.server.controllers.repository.UserRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMakerRepository accountMakerRepository;
    @Autowired
    private Services<UserForm> userService;

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<AccountDto> newAccount(@RequestBody @Valid UserForm userForm,
                                                 UriComponentsBuilder uriBuilder) throws NatbankException {
        userService.verify(userForm);

        User user = userForm.convert();
        configureAccountMaker();
        Account newAccount = new Account(user, accountMakerRepository);

        accountRepository.save(newAccount);
        user.setAccount(newAccount);
        userRepository.save(user);

        URI uri = uriBuilder.path("/account/{id}").buildAndExpand(newAccount.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountDto(newAccount));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountDetails(@PathVariable("id") Long id) {
        Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()) {
            return ResponseEntity.ok(new AccountDto(account.get()));
        }

        return ResponseEntity.badRequest().build();
    }

    private void configureAccountMaker() {
        Optional<AccountMaker> accountMaker = accountMakerRepository.findById(1L);
        if (accountMaker.isEmpty()) {
            accountMakerRepository.save(new AccountMaker(1L, "0001", 12344L));
        }
    }

    @PostMapping
    public ResponseEntity<?> verifyCredentials(@Valid @RequestBody UserCredentialForm credentialForm) {
        Optional<User> optionalUser = userRepository.findByCpf(credentialForm.getCpf());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (new BCryptPasswordEncoder(10).matches(credentialForm.getPassword(), user.getPassword()))
                return ResponseEntity.ok(new AccountDto(user.getAccount()));
            else
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Password is not valid");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF is not valid");
    }
}