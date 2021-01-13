package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.User;

import java.util.List;

public interface UserService {
    void createUser(String name, String surname, String login, String password);
    void save(String name, String surname, String login, String password);
    void save(User user);
    void delete(Long id);
    User update(Long id, String name, String surname, String login, String password);
    User update(User user);
    List<User> findAll();
}
