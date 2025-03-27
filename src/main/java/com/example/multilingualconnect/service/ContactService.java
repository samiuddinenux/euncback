package com.example.multilingualconnect.service;

import com.example.multilingualconnect.entity.Contact;
import com.example.multilingualconnect.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact submitContact(String name, String email, String message) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setMessage(message);
        return contactRepository.save(contact);
    }
}