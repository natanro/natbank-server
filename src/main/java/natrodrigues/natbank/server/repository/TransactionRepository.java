package natrodrigues.natbank.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import natrodrigues.natbank.server.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
