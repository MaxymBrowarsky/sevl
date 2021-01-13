package ua.nulp.sevl.coding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nulp.sevl.coding.model.Attempt;
import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.User;
import ua.nulp.sevl.coding.repository.AttemptRepository;
import ua.nulp.sevl.coding.service.AttemptService;

import java.util.List;
import java.util.Optional;

@Service
public class AttemptServiceImpl implements AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Override
    public void save(Attempt attempt) {
        attemptRepository.save(attempt);
    }

    @Override
    public void save(User user, Long time, Integer grade, String solution, Task task) {
        Attempt attempt = new Attempt(user, time, grade, solution, task);
        attemptRepository.save(attempt);
    }

    @Override
    public void delete(Long id) {
        attemptRepository.deleteById(id);
    }

    @Override
    public Attempt update(Long id, User user, Long time, Integer grade, String solution, Task task) {
        Optional<Attempt> r = attemptRepository.findById(id);
        if (r.isPresent()) {
            Attempt a = r.get();
            return a.setUser(user)
                    .setTime(time)
                    .setGrade(grade)
                    .setSolution(solution)
                    .setTask(task);
        }
        return attemptRepository.findById(id).get();
    }

    @Override
    public Attempt update(Attempt attempt) {
        Optional<Attempt> r = attemptRepository.findById(attempt.getId());
        if (r.isPresent()) {
            Attempt a = r.get();
            return a.setUser(attempt.getUser())
                    .setTime(attempt.getTime())
                    .setGrade(attempt.getGrade())
                    .setSolution(attempt.getSolution())
                    .setTask(attempt.getTask());
        }
        return attemptRepository.findById(attempt.getId()).get();
    }

    @Override
    public Attempt find(Long id) {
        return attemptRepository.findById(id).get();
    }

    @Override
    public List<Attempt> findAll() {
        return attemptRepository.findAll();
    }
}
