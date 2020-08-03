package natrodrigues.natbank.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import natrodrigues.natbank.server.models.Transaction;
import natrodrigues.natbank.server.models.TransactionId;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
}
