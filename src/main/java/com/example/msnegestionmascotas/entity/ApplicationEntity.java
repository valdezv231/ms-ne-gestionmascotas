package com.example.msnegestionmascotas.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "applications")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_code", unique = true, nullable = false)
    private String applicationCode;

    @Getter
    @Column(name = "application_name", nullable = false)
    private String applicationName;

    private boolean enabled = true;
}
