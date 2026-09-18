package com.saadMeddiche.audit_via_hibernate_envers.repositories;

import com.saadMeddiche.audit_via_hibernate_envers.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface BookRepository extends JpaRepository<Book, Long>, RevisionRepository<Book, Long, Integer> {}