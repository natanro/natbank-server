package natrodrigues.natbank.server.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import natrodrigues.natbank.server.dto.AccountDto;
import natrodrigues.natbank.server.form.UserForm;
import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.models.AccountMaker;
import natrodrigues.natbank.server.models.User;
import natrodrigues.natbank.server.repository.AccountMakerRepository;
import natrodrigues.natbank.server.repository.AccountRepository;
import natrodrigues.natbank.server.repository.UserRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMakerRepository accountMakerRepository;
    
    @PostMapping("/new")
    @Transactional
    public ResponseEntity<AccountDto> newAccount(@RequestBody @Valid UserForm userForm,
            UriComponentsBuilder uriBuilder) {
        User user = userForm.convert();
        configureAccountMaker();
        Account newAccount = new Account(user, accountMakerRepository);
        
        accountRepository.save(newAccount);
        user.setAccount(newAccount);
        userRepository.save(user);
        
        // TODO: enviar e-mail para o email do usuario cadastrado
        
        URI uri = uriBuilder.path("/account/{id}").buildAndExpand(newAccount.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountDto(newAccount));
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountDetails(@PathVariable("id") Long id) {
        Optional<Account> account = accountRepository.findById(id);
        
        if(account.isPresent()) {
            return ResponseEntity.ok(new AccountDto(account.get()));
        }
        
        return ResponseEntity.badRequest().build();
    }

    private void configureAccountMaker() {
        Optional<AccountMaker> accountMaker = accountMakerRepository.findById(1L);
        if(!accountMaker.isPresent()) {
            accountMakerRepository.save(new AccountMaker(1L, "0001", 12344L));
        }
    }
}