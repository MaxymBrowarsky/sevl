package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.TestCase;

import java.util.List;
import java.util.Set;

public interface TestCaseService {
    void save(TestCase testCase);
    void save(String input, String result, Set<Task> tasks);
    void delete(Long id);
    TestCase update(Long id, String input, String result, Set<Task> tasks);
    TestCase update(TestCase testCase);
    TestCase find(Long id);
    List<TestCase> findAll();
}
