package ua.nulp.sevl.coding.model;

import javax.persistence.*;

@Entity
public class Attempt {
    @Id
    @GeneratedValue
    private Long id;
    //TODO add hibernate mapping to user also change constructor and add getter and setter
//    @ManyToOne
//    @JoinColumn(name="userId", nullable=false)
    private User user;
    private Long time;
    private Integer grade;
    private String solution;
    @ManyToOne
    @JoinColumn(name="taskId", nullable=true)
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
