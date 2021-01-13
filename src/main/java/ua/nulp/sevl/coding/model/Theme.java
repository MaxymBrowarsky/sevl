package ua.nulp.sevl.coding.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Theme {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @OneToMany
    private Set<Task> tasks;

    public Theme() {
    }

    public Theme(String text, Set<Task> tasks) {
        this.text = text;
        this.tasks = tasks;
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public Theme setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
