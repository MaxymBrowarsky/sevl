package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.Attempt;
import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.User;

import java.util.List;

public interface AttemptService {
    void save(Attempt attempt);
    void save(User user, Long time, Integer grade, String solution, Task task);
    void delete(Long id);
    Attempt update(Long id, User user, Long time, Integer grade, String solution, Task task);
    Attempt update(Attempt attempt);
    Attempt find(Long id);
    List<Attempt> findAll();
}
