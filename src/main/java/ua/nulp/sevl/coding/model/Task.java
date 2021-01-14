package ua.nulp.sevl.coding.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String author;
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tasktestcase",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "test_case_id"))
    private List<TestCase> testCases;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tasklabel",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Label> labels;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "taskattempt",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "attempt_id"))
    private List<Attempt> attempts;

    public Task() {
    }

    public Task(String title, String description, String author, Theme theme, List<TestCase> testCases, List<Label> labels, List<Attempt> attempts) {
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

    public Theme getTheme() {
        return theme;
    }

    public Task setTheme(Theme theme) {
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
