package com.example.multilingualconnect.controller;

import com.example.multilingualconnect.dto.LandingPageContent;
import com.example.multilingualconnect.entity.Contact;
import com.example.multilingualconnect.entity.Language;
import com.example.multilingualconnect.entity.Subscription;
import com.example.multilingualconnect.service.ContactService;
import com.example.multilingualconnect.service.LanguageService;
import com.example.multilingualconnect.service.SubscriptionService;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final SubscriptionService subscriptionService;
    private final LanguageService languageService;
    private final ContactService contactService;
    private final MessageSource messageSource;

    public ApiController(SubscriptionService subscriptionService,
                         LanguageService languageService,
                         ContactService contactService,
                         MessageSource messageSource) {
        this.subscriptionService = subscriptionService;
        this.languageService = languageService;
        this.contactService = contactService;
        this.messageSource = messageSource;
    }

    @PostMapping("/subscribe")
    public Subscription subscribe(@RequestBody SubscriptionRequest request) {
        return subscriptionService.subscribe(request.email());
    }

    @PostMapping("/languages")
    public Language addLanguage(@RequestBody LanguageRequest request) {
        return languageService.addLanguage(request.code(), request.name(), request.isActive());
    }

    @PostMapping("/contact")
    public Contact submitContact(@RequestBody ContactRequest request) {
        return contactService.submitContact(request.name(), request.email(), request.message());
    }

    // New endpoint to get landing page content based on language
    @GetMapping("/landing-content")
    public LandingPageContent getLandingContent(@RequestParam("lang") String lang) {
        Locale locale = new Locale(lang);
        return new LandingPageContent(
                messageSource.getMessage("landing.title", null, locale),
                messageSource.getMessage("landing.subtitle", null, locale),
                messageSource.getMessage("landing.description", null, locale),
                messageSource.getMessage("landing.subscribe", null, locale),
                messageSource.getMessage("landing.contact", null, locale)
        );
    }

    // DTO Records
    public record SubscriptionRequest(String email) {}
    public record LanguageRequest(String code, String name, boolean isActive) {}
    public record ContactRequest(String name, String email, String message) {}
}