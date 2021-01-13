package ua.nulp.sevl.coding.model;

import javax.persistence.*;

@Entity
public class TestCase {
    @Id
    @GeneratedValue
    private Long id;
    private String input;
    private String result;
    @ManyToMany
    @JoinTable(
            name = "TaskTestCase",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "test_case_id"))
    private Task task;

    public TestCase() {
    }

    public TestCase(String input, String result, Task task) {
        this.input = input;
        this.result = result;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public TestCase setInput(String input) {
        this.input = input;
        return this;
    }

    public String getResult() {
        return result;
    }

    public TestCase setResult(String result) {
        this.result = result;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public TestCase setTask(Task task) {
        this.task = task;
        return this;
    }
}
