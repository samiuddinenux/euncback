package com.example.multilingualconnect.service;

import com.example.multilingualconnect.entity.Language;
import com.example.multilingualconnect.repository.LanguageRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @PostConstruct
    public void initLanguages() {
        if (languageRepository.count() == 0) {
            createLanguage("ar", "Arabic", true);
            createLanguage("en", "English", true);
            createLanguage("fr", "French", true);
            createLanguage("es", "Spanish", true);
        }
    }

    public Language createLanguage(String code, String name, boolean isActive) {
        if (languageRepository.existsByCode(code)) {
            throw new RuntimeException("Language code already exists");
        }
        Language language = new Language();
        language.setCode(code);
        language.setName(name);
        language.setActive(isActive);
        return languageRepository.save(language);
    }

    public Language addLanguage(String code, String name, boolean isActive) {
        return createLanguage(code, name, isActive);
    }
}