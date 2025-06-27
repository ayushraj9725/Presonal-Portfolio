package org.portfolio.portfoliobackend.Repository;

import org.portfolio.portfoliobackend.Model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {

    // Optional<ContactMessage> findAllContactMessages();

}
