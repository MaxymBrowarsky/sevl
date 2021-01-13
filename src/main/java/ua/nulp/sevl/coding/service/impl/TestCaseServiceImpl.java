package ua.nulp.sevl.coding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.model.TestCase;
import ua.nulp.sevl.coding.repository.TestCaseRepository;
import ua.nulp.sevl.coding.service.TestCaseService;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public void save(TestCase testCase) {
        testCaseRepository.save(testCase);
    }

    @Override
    public void save(String input, String result, Task task) {
        TestCase testCase = new TestCase(input, result, task);
        testCaseRepository.save(testCase);
    }

    @Override
    public void delete(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public TestCase update(Long id, String input, String result, Task task) {
        Optional<TestCase> r = testCaseRepository.findById(id);
        if (r.isPresent()) {
            TestCase t = r.get();
            return t.setInput(input)
                    .setResult(result)
                    .setTask(task);
        }
        return testCaseRepository.findById(id).get();
    }

    @Override
    public TestCase update(TestCase testCase) {
        Optional<TestCase> r = testCaseRepository.findById(testCase.getId());
        if (r.isPresent()) {
            TestCase t = r.get();
            return t.setInput(testCase.getInput())
                    .setResult(testCase.getResult())
                    .setTask(testCase.getTask());
        }
        return testCaseRepository.findById(testCase.getId()).get();
    }

    @Override
    public TestCase find(Long id) {
        return testCaseRepository.findById(id).get();
    }

    @Override
    public List<TestCase> findAll() {
        return testCaseRepository.findAll();
    }
}
