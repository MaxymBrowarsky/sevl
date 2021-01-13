package ua.nulp.sevl.coding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.Set;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "second_name")
    private String surname;
    @Column(name = "nic_name")
    private String login;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roles;

    @OneToMany
    private Set<Attempt> attempts;

    public User() {

    }

    public User(String name, String surname, String login, String password, Role roles, Set<Attempt> attempts) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.attempts = attempts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Role getRoles() {
        return roles;
    }

    public User setRoles(Role roles) {
        this.roles = roles;
        return this;
    }

    public Set<Attempt> getAttempts() {
        return attempts;
    }

    public User setAttempts(Set<Attempt> attempts) {
        this.attempts = attempts;
        return this;
    }
}
