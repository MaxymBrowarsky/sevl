package ua.nulp.sevl.coding.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "label")
public class Label {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "text")
    private String text;
    @ManyToMany
    @JoinTable(
            name = "TaskLabel",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Task> task;

    public Label() {
    }

    public Label(String text, List<Task> task) {
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

    public List<Task> getTask() {
        return task;
    }

    public Label setTask(List<Task> task) {
        this.task = task;
        return this;
    }
}
