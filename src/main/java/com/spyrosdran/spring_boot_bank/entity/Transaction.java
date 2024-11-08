package com.spyrosdran.spring_boot_bank.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "payer_id")
    private int payerId;

    @Column(name = "receiver_id")
    private int receiverId;

    @Column(name = "amount")
    private float amount;

}
