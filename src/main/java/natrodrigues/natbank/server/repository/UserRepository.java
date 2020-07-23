package natrodrigues.natbank.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import natrodrigues.natbank.server.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
