package ua.nulp.sevl.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nulp.sevl.coding.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
}
