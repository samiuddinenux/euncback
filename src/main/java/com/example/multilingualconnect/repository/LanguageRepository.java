package com.example.multilingualconnect.repository;

import com.example.multilingualconnect.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    boolean existsByCode(String code);
}