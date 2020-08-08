package natrodrigues.natbank.server.controllers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import natrodrigues.natbank.server.models.AccountMaker;

public interface AccountMakerRepository extends JpaRepository<AccountMaker, Long> {
}
