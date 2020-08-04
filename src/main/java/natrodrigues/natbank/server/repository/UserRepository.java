package natrodrigues.natbank.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import natrodrigues.natbank.server.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByCpf(String cpf);
}
