package com.saadMeddiche.audit_via_hibernate_envers.audit_reader;

import com.saadMeddiche.audit_via_hibernate_envers.entities.Book;
import com.saadMeddiche.audit_via_hibernate_envers.repositories.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.history.Revisions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Reader {

    private final BookRepository bookRepository;

    private final static String LOG_TEMPLATE = "{TYPE} | {TIME} : {SNAPSHOT}";

    @Scheduled(fixedDelay = 1)
    @Transactional(readOnly = true)
    public void print() {

        Revisions<Integer, Book> revisions = this.bookRepository.findRevisions(1L);

        for (var revision : revisions) {

            var type = revision.getMetadata().getRevisionType();
            var instant = revision.getMetadata().getRequiredRevisionInstant();
            var entity = revision.getEntity();

            System.out.println(
                    LOG_TEMPLATE.replace("{TYPE}", type.toString())
                            .replace("{TIME}", instant.toString())
                            .replace("{SNAPSHOT}", entity.toString())
            );

        }

        System.exit(0);

    }

}