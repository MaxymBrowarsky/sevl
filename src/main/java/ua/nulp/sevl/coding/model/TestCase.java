package ua.nulp.sevl.coding.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "testcase")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String input;
    private String result;
    @ManyToMany(mappedBy = "testCases")
//    @JoinTable(
//            name = "TaskTestCase",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "test_case_id"))
    private Set<Task> tasks;

    public TestCase() {
    }

    public TestCase(String input, String result) {
        this.input = input;
        this.result = result;
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public TestCase setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
