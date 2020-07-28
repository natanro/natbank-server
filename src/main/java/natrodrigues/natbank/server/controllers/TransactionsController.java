package natrodrigues.natbank.server.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import natrodrigues.natbank.server.config.exception.FormError;
import natrodrigues.natbank.server.config.exception.NatbankException;
import natrodrigues.natbank.server.form.TransactionForm;
import natrodrigues.natbank.server.models.Account;
import natrodrigues.natbank.server.models.Transaction;
import natrodrigues.natbank.server.models.TransactionType;
import natrodrigues.natbank.server.repository.AccountRepository;
import natrodrigues.natbank.server.repository.TransactionRepository;
import natrodrigues.natbank.server.services.AccountService;
import natrodrigues.natbank.server.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionRepository transactionRepository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<?> newTransaction(@RequestBody @Valid TransactionForm transactionForm, Errors errors)
     throws NatbankException {
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().body(FormError.getErrorList(errors));
        }
        transactionService.verify(transactionForm);
        accountService.verify(transactionForm.getContact().getAccountNumber());

        Transaction transaction = transactionForm.convert();
        Account senderAccount = transactionForm.getAccountForm().convert(accountRepository);
        Account recieverAccount = accountRepository.findByNumber(
            transaction.getContact().getAccountNumber()).get();
        
        senderAccount.addTransaction(transaction, TransactionType.SEND);
        recieverAccount.addTransaction(transaction, TransactionType.RECIEVE);

        transactionRepository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}