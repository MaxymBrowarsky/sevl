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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return null;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Task setAuthor(String author) {
        this.author = author;
        return this;
    }

    public List<Theme> getTheme() {
        return theme;
    }

    public Task setTheme(List<Theme> theme) {
        this.theme = theme;
        return this;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public Task setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
        return this;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public Task setLabels(List<Label> labels) {
        this.labels = labels;
        return this;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public Task setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
        return this;
    }
}
