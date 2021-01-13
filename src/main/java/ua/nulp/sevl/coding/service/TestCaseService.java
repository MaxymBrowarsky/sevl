package ua.nulp.sevl.coding.service;

import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.TestCase;

import java.util.List;

public interface TestCaseService {
    void save(TestCase testCase);
    void save(String input, String result, Task task);
    void delete(Long id);
    TestCase update(Long id, String input, String result, Task task);
    TestCase update(TestCase testCase);
    TestCase find(Long id);
    List<TestCase> findAll();
}
