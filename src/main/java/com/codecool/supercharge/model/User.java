package com.codecool.supercharge.model;


import javax.persistence.*;

@Entity
@Table(name = "member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String password;

    @OneToOne
    private Account account;







}
