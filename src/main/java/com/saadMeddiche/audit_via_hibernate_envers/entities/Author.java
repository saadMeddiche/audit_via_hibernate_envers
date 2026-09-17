package com.saadMeddiche.audit_via_hibernate_envers.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Audited
@Getter @Setter
public class Author {

    @Id
    @GeneratedValue(generator = "author_sequence_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "author_sequence_generator", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private OffsetDateTime birthdate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books;

}