package natrodrigues.natbank.server.services;

import java.util.Optional;

import natrodrigues.natbank.server.config.exception.NatbankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import natrodrigues.natbank.server.config.exception.TransactionException;
import natrodrigues.natbank.server.controllers.form.TransactionForm;
import natrodrigues.natbank.server.models.Transaction;
import natrodrigues.natbank.server.models.TransactionId;
import natrodrigues.natbank.server.models.TransactionType;
import natrodrigues.natbank.server.controllers.repository.TransactionRepository;

@Service
public class TransactionService implements Services<TransactionForm> {

    public static final String TRANSACTION_ALREADY_EXISTS = "Transaction already exists";
    public static final String UUID = "uuid";
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void verify(TransactionForm transactionForm) throws NatbankException {
        String uuid = transactionForm.getUuid();
        Optional<Transaction> transaction = transactionRepository.findById(
            new TransactionId(uuid, TransactionType.RECIEVE));
        if(transaction.isPresent()) {
            throw new TransactionException(UUID, TRANSACTION_ALREADY_EXISTS);
        }
    }
}
