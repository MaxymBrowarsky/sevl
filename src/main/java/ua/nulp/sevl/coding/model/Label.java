package ua.nulp.sevl.coding.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "label")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    private String text;
    @ManyToMany(mappedBy = "labels")
//    @JoinTable(
//            name = "TaskLabel",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Task> tasks;

    public Label() {
    }

    public Label(String text) {
        this.text = text;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public Label setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
