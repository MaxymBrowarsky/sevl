package ua.nulp.sevl.coding.model;

import javax.persistence.*;

@Entity
public class Attempt {
    @Id
    @GeneratedValue
    private Long id;
    //TODO add hibernate mapping to user also change constructor and add getter and setter
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private Long time;
    private Integer grade;
    private String solution;
    @ManyToOne
    @JoinColumn(name="task_id", nullable=true)
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

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
