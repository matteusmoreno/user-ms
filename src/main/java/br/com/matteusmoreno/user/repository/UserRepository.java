package br.com.matteusmoreno.user.repository;

import br.com.matteusmoreno.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
