package com.saadMeddiche.audit_via_hibernate_envers.repositories;

import com.saadMeddiche.audit_via_hibernate_envers.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface TagRepository extends JpaRepository<Tag, Long>, RevisionRepository<Tag, Long, Integer> {}