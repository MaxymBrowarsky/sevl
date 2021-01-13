package ua.nulp.sevl.coding.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String author;
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
    @ManyToMany
    @JoinTable(
            name = "TaskLabel",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<TestCase> testCases;
    @ManyToMany
    @JoinTable(
            name = "TaskTestCase",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Label> labels;
    @ManyToMany
    @JoinTable(
            name = "TaskAttempt",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
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
