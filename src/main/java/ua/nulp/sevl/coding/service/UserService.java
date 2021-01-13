package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.Attempt;
import ua.nulp.sevl.coding.model.Role;
import ua.nulp.sevl.coding.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void createUser(String name, String surname, String login, String password, Role roles, Set<Attempt> attempts);
    void save(String name, String surname, String login, String password, Role roles, Set<Attempt> attempts);
    void save(User user);
    void delete(Long id);
    User update(Long id, String name, String surname, String login, String password, Role roles, Set<Attempt> attempts);
    User update(User user);
    List<User> findAll();
    User findByLogin(String login);
}
