package com.saadMeddiche.audit_via_hibernate_envers.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Audited
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(generator = "book_sequence_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_sequence_generator", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @NaturalId(mutable = true)
    @Column(nullable = false, unique = true)
    private UUID serial;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tag> tags;

    public void addTag(Tag tag) {
        if(tag == null) return;
        if(this.tags == null) this.tags = new ArrayList<>();
        this.tags.add(tag);
    }

}