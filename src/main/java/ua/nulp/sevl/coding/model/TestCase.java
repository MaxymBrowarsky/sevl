package ua.nulp.sevl.coding.model;

import javax.persistence.*;

@Entity
public class TestCase {
    @Id
    @GeneratedValue
    private Long id;
    private String input;
    private String result;
    @Column(name = "task_id", insertable = false, updatable = false)
    private Long taskId;
    @ManyToOne
    @JoinColumn(name="task_id", nullable=true)
    private Task task;

    public TestCase() {
    }

    public TestCase(String input, String result, Long taskId, Task task) {
        this.input = input;
        this.result = result;
        this.taskId = taskId;
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

    public void setInput(String input) {
        this.input = input;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
