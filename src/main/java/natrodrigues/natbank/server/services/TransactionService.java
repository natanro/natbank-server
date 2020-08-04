package natrodrigues.natbank.server.services;

import java.util.Optional;

import javax.validation.Valid;

import natrodrigues.natbank.server.config.exception.NatbankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import natrodrigues.natbank.server.config.exception.TransactionException;
import natrodrigues.natbank.server.form.TransactionForm;
import natrodrigues.natbank.server.models.Transaction;
import natrodrigues.natbank.server.models.TransactionId;
import natrodrigues.natbank.server.models.TransactionType;
import natrodrigues.natbank.server.repository.TransactionRepository;

@Service
public class TransactionService implements Services<TransactionForm> {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void verify(TransactionForm transactionForm) throws NatbankException {
        String uuid = transactionForm.getUuid();
        Optional<Transaction> transaction = transactionRepository.findById(
            new TransactionId(uuid, TransactionType.RECIEVE));
        if(transaction.isPresent()) {
            throw new TransactionException("uuid", "Trasaction already exists");
        }
    }
}
