package natrodrigues.natbank.server.controllers.repository;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import natrodrigues.natbank.server.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByNumber(@NotNull Long number);
}
