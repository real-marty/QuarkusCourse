import org.agoncal.quarkus.jpa.*;

import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    @PersistenceUnit("asset")
    private EntityManager em;

    public void persist(Customer customer) {
        em.persist(customer);
    }

    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }

}
