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

    private String applicationName;
    private String applicationCode;
    private String consumerId;
    private boolean active;
}