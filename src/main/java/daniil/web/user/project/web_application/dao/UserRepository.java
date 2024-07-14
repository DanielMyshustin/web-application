package daniil.web.user.project.web_application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import daniil.web.user.project.web_application.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findUserByUsername(String username);
    
    Optional<User> findByUsername(String username);
}
