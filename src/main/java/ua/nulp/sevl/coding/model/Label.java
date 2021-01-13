package ua.nulp.sevl.coding.model;

import javax.persistence.*;

@Entity
public class Label {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name="taskId", nullable=true)
    private Task task;

    public Label() {
    }

    public Label(String text, Task task) {
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

    public Label setText(String text) {
        this.text = text;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public Label setTask(Task task) {
        this.task = task;
        return this;
    }
}
