package ua.nulp.sevl.coding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nulp.sevl.coding.model.User;
import ua.nulp.sevl.coding.repository.UserRepository;
import ua.nulp.sevl.coding.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(String name, String surname, String login, String password) {
        User user = new User(name, surname, login, password);
        save(user);
    }

    public void save(String name, String surname, String login, String password) {
        User user = new User(name, surname, login, password);
        userRepository.save(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, String name, String surname, String login, String password) {
        Optional<User> r = userRepository.findById(id);
        if (r.isPresent()) {
            User u = r.get();
            return u.setName(name).setSurname(surname).setPassword(password);
        }
        return userRepository.findById(id).get();
    }

    public User update(User user) {
        return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
