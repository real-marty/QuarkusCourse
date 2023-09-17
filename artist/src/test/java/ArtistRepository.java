import org.agoncal.quarkus.jdbc.Artist;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ArtistRepository {

    @Inject
    EntityManager em;

    public void persist(Artist artist) {
        em.persist(artist);
    }

    public Artist findById(Long id) {
        return em.find(Artist.class, id);

    }
}
