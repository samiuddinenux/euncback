package com.example.multilingualconnect.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String message;
}