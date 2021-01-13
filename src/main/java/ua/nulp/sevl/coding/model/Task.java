package ua.nulp.sevl.coding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String author;
    @OneToMany(mappedBy="task")
    private List<Theme> theme;
    @OneToMany(mappedBy="task")
    private List<TestCase> testCases;
    @OneToMany(mappedBy="task")
    private List<Label> labels;
    @OneToMany(mappedBy="task")
    private List<Attempt> attempts;

    public Task() {
    }

    public Task(String title, String description, String author, List<Theme> theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.theme = theme;
        this.testCases = testCases;
        this.labels = labels;
        this.attempts = attempts;
    }

}
