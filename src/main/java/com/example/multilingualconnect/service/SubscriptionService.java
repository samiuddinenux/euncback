package com.example.multilingualconnect.service;

import com.example.multilingualconnect.entity.Subscription;
import com.example.multilingualconnect.repository.SubscriptionRepository;
import com.example.multilingualconnect.exception.SubscriptionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription subscribe(String email) {
        if (subscriptionRepository.existsByEmail(email)) {
            String errorMessage = "Email " + email + " is already subscribed.";
            int statusCode = 400; // HTTP 400 Bad Request
            logger.error("Error code: {}, Error message: {}", statusCode, errorMessage);
            throw new SubscriptionException(statusCode, errorMessage);
        }
        Subscription subscription = new Subscription();
        subscription.setEmail(email);
        return subscriptionRepository.save(subscription);
    }
}
