package com.saadMeddiche.audit_via_hibernate_envers.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Getter @Setter
public class Tag {

    @Id
    @GeneratedValue(generator = "tag_sequence_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tag_sequence_generator", allocationSize = 1, initialValue = 1)
    private Long id;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String value;

}