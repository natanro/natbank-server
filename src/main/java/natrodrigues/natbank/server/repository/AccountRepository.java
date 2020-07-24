package natrodrigues.natbank.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import natrodrigues.natbank.server.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
