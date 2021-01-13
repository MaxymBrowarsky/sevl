package ua.nulp.sevl.coding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nulp.sevl.coding.model.*;
import ua.nulp.sevl.coding.repository.TaskRepository;
import ua.nulp.sevl.coding.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(String title, String description, String author, List<Theme> theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts) {
        Task task = new Task(title, description, author, theme, testCases, labels, attempts);
        save(task);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void save(String title, String description, String author, List<Theme> theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts) {
        Task task = new Task(title, description, author, theme, testCases, labels, attempts);
        taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task) {
        Optional<Task> r = taskRepository.findById(task.getId());
        if (r.isPresent()) {
            Task t = r.get();
            return t.setTitle(task.getTitle())
                    .setDescription(task.getDescription())
                    .setAuthor(task.getAuthor())
                    .setTheme(task.getTheme())
                    .setTestCases(task.getTestCases())
                    .setLabels(task.getLabels())
                    .setAttempts(task.getAttempts());
        }
        return taskRepository.findById(task.getId()).get();
    }

    @Override
    public Task update(Long id, String title, String description, String author, List<Theme> theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts) {
        Optional<Task> r = taskRepository.findById(id);
        if (r.isPresent()) {
            Task t = r.get();
            return t.setTitle(title)
                    .setDescription(description)
                    .setAuthor(author)
                    .setTheme(theme)
                    .setTestCases(testCases)
                    .setLabels(labels)
                    .setAttempts(attempts);
        }
        return taskRepository.findById(id).get();
    }

    @Override
    public Task find(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByTheme(Theme theme) {
        return taskRepository.findByTheme(theme);
    }

    @Override
    public List<Task> findByThemeId(Long id) {
        return taskRepository.findByThemeId(id);
    }

    @Override
    public List<Task> findWithLabels(List<Label> labels) {
        return taskRepository.findWithLabels(labels);
    }

    @Override
    public List<Task> findByAuthor(String author) {
        return taskRepository.findByAuthor(author);
    }
}
