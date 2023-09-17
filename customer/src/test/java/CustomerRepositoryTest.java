import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.agoncal.qurkus.jpa.Customer;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnArtist() throws SQLException {
        Customer customer = new Customer("name", "surname", "mail@email.com");

        repository.persist(customer);
        assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("name", customer.getName());
        assertEquals("surname", customer.getSurname());
        assertEquals("mail@email.com", customer.getEmail());

    }

}