package org.agoncal.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.agoncal.qurkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnPublisher() throws SQLException {
        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);
        assertEquals("name", publisher.name);

    }

}