package com.udl.softarch.springexample.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 23/03/15.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email shoud be valid")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Greeting> greetings = new ArrayList<Greeting>();

    public User() {}

    public User(String username, String email) {
        this.username = username;
        this.email=email;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Greeting> getGreetings() {
        return greetings;
    }

    public void addGreeting(Greeting newGreeting) {
        greetings.add(newGreeting);
    }

    public void removeGreeting(Greeting greeting) {
        greetings.remove(greeting);
    }
}
