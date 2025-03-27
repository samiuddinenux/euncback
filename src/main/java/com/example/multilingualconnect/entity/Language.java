package com.example.multilingualconnect.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;
    private boolean isActive;
}