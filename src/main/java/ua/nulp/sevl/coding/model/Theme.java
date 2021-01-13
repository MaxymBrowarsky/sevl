package ua.nulp.sevl.coding.model;

import javax.persistence.*;

@Entity
public class Theme {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name="taskId", nullable=true)
    private Task task;

    public Theme() {
    }

    public Theme(String text, Task task) {
        this.text = text;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Theme setText(String text) {
        this.text = text;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public Theme setTask(Task task) {
        this.task = task;
        return this;
    }
}
