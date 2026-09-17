package com.saadMeddiche.audit_via_hibernate_envers.scenarios;

import com.saadMeddiche.audit_via_hibernate_envers.entities.Author;
import com.saadMeddiche.audit_via_hibernate_envers.entities.Book;
import com.saadMeddiche.audit_via_hibernate_envers.entities.Tag;
import com.saadMeddiche.audit_via_hibernate_envers.repositories.AuthorRepository;
import com.saadMeddiche.audit_via_hibernate_envers.repositories.BookRepository;
import com.saadMeddiche.audit_via_hibernate_envers.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ScenarioPlayer implements CommandLineRunner {

    private final TagRepository tagRepository;
    private final List<String> tagValues = List.of("Funny", "Action", "Finance", "History");

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {

        List<Tag> tags = create_tags();

        var author = create_author_with_wrong_name();

        fix_author_with_wrong_name(author);

        var book = create_book_for_author(author);

        update_book_serial(book);

        add_tags_to_book(book, tags.getFirst());

    }

    public List<Tag> create_tags() {

        List<Tag> tagsToCreate = new ArrayList<>();

        for(String tagValue : tagValues) {

            Tag tag = new Tag();

            tag.setValue(tagValue);

            tagsToCreate.add(tag);

        }

        return this.tagRepository.saveAll(tagsToCreate);

    }

    public Author create_author_with_wrong_name() {

        Author author = new Author();

        author.setFirstName("Saade");
        author.setLastName("Meddiche");
        author.setBirthdate(
                OffsetDateTime.of(
                        LocalDate.of(2004, 1 ,20),
                        LocalTime.of(11, 0,0),
                        ZoneOffset.UTC
                )
        );

        return this.authorRepository.save(author);

    }

    public void fix_author_with_wrong_name(Author author) {

        author.setFirstName("Saad");

        this.authorRepository.save(author);

    }

    public Book create_book_for_author(Author author) {

        Book book = new Book();
        book.setTitle("My Life");
        book.setSerial(UUID.randomUUID());
        book.setAuthor(author);

        return this.bookRepository.save(book);

    }

    public void update_book_serial(Book book) {

        book.setSerial(UUID.randomUUID());

        this.bookRepository.save(book);

    }

    public void add_tags_to_book(Book book, Tag... tags) {

        for (var tag : tags) {
            book.addTag(tag);
        }

        this.bookRepository.save(book);

    }

}