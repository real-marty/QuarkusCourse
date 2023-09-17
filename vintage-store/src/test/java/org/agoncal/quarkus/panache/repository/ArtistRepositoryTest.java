package org.agoncal.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.qurkus.panache.repository.ArtistRepository;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnArtist() throws SQLException {
        Artist artist = new Artist("name", "bio");
        repository.persist(artist);

        assertNotNull(artist.getId());

        artist = repository.findById(artist.getId());
        assertEquals("name", artist.getName());

    }

}
