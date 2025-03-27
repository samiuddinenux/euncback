package com.example.multilingualconnect.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private boolean active = true;
}