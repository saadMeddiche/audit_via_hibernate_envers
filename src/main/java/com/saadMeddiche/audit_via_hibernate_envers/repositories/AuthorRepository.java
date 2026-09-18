package com.saadMeddiche.audit_via_hibernate_envers.repositories;

import com.saadMeddiche.audit_via_hibernate_envers.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>, RevisionRepository<Author, Long, Integer> {}