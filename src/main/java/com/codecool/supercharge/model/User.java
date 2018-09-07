package com.codecool.supercharge.model;


import javax.persistence.*;

@Entity
@Table(name = "member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @OneToOne
    private Account account;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = new Account(this);
    }
    

}
