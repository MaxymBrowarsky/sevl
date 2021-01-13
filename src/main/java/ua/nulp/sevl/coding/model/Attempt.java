package ua.nulp.sevl.coding.model;

import javax.persistence.*;

@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @Column(name = "time")
    private Long time;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "solution")
    private String solution;
    @ManyToMany
    @JoinTable(
            name = "TaskAttempt",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "attempt_id"))
    private Task task;

    public Attempt() {
    }

    public Attempt(User user, Long time, Integer grade, String solution, Task task) {
        this.user = user;
        this.time = time;
        this.grade = grade;
        this.solution = solution;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Attempt setUser(User user) {
        this.user = user;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public Attempt setTime(Long time) {
        this.time = time;
        return this;
    }

    public Integer getGrade() {
        return grade;
    }

    public Attempt setGrade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public String getSolution() {
        return solution;
    }

    public Attempt setSolution(String solution) {
        this.solution = solution;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public Attempt setTask(Task task) {
        this.task = task;
        return this;
    }
}
