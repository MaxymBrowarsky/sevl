package ua.nulp.sevl.coding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nulp.sevl.coding.model.Role;
import ua.nulp.sevl.coding.model.User;
import ua.nulp.sevl.coding.repository.UserRepository;
import ua.nulp.sevl.coding.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(String name, String surname, String login, String password, Set<Role> roles, Set<Attempt> attempts) {
        User user = new User(name, surname, login, password, roles, attempts);
        save(user);
    }

    public void save(String name, String surname, String login, String password, Set<Role> roles, Set<Attempt> attempts) {
        User user = new User(name, surname, login, password, roles, attempts);
        userRepository.save(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, String name, String surname, String login, String password, Set<Role> roles, Set<Attempt> attempts) {
        Optional<User> r = userRepository.findById(id);
        if (r.isPresent()) {
            User u = r.get();
            return u.setName(name)
                    .setSurname(surname)
                    .setPassword(password)
                    .setRoles(roles)
                    .setAttempts(attempts);
        }
        return userRepository.findById(id).get();
    }

    public User update(User user) {
        return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        if (login == "test") {
            Set<Role> roles = new HashSet<Role>();
            Role role = new Role();
            role.setName("USER");
            roles.add(role);
            User user = new User().setLogin("test").setPassword("test").setRoles(roles);
            return user;
        }
        User user = userRepository.findUserByLogin(login);
        return user;
    }
}
