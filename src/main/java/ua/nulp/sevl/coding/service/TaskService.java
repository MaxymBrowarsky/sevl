package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.*;

import java.util.List;

public interface TaskService {
    void createTask(String title, String description, String author, Theme theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts);
    void save(Task task);
    void save(String title, String description, String author, Theme theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts);
    void delete(Long id);
    Task update(Task task);
    Task update(Long id, String title, String description, String author, Theme theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts);
    Task find(Long id);
    List<Task> findAll();
    List<Task> findByTheme(Theme theme);
    List<Task> findByThemeId(Long id);
    List<Task> findWithLabels(List<Label> labels);
    List<Task> findByAuthor(String author);
}
