package com.codecool.supercharge.model;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    private Date date;
    private String event;

    private int change;
}
