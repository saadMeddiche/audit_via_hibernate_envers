package com.saadMeddiche.audit_via_hibernate_envers.repositories;

import com.saadMeddiche.audit_via_hibernate_envers.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}