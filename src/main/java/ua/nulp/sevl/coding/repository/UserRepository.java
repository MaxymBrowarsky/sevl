package ua.nulp.sevl.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.nulp.sevl.coding.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from User u where u.nic_name = ?1", nativeQuery = true)
    User myquery(String login);
}
