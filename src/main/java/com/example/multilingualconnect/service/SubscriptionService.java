package com.example.multilingualconnect.service;

import com.example.multilingualconnect.entity.Subscription;
import com.example.multilingualconnect.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription subscribe(String email) {
        if (subscriptionRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already subscribed");
        }
        Subscription subscription = new Subscription();
        subscription.setEmail(email);
        return subscriptionRepository.save(subscription);
    }
}