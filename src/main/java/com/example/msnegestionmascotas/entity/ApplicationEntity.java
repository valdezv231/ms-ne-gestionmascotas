package com.example.msnegestionmascotas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_code")
    private String applicationCode;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "consumer_id")
    private String consumerId;
}