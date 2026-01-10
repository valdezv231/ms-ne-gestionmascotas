package com.example.msnegestionmascotas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "consumers")
public class ConsumerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consumer_id", unique = true, nullable = false)
    private String consumerId;

    private boolean enabled = true;
}
