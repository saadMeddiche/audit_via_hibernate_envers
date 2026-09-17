package com.saadMeddiche.audit_via_hibernate_envers.repositories;

import com.saadMeddiche.audit_via_hibernate_envers.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {}