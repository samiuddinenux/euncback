package com.example.multilingualconnect.repository;

import com.example.multilingualconnect.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}