
package org.agoncal.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.agoncal.quarkus.jpa.Customer;
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
    public void shouldCreateAndFindAnArtist() {
        Customer customer = new Customer("name", "surname", "mail@email.com");

        repository.persist(customer);
        assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("name", customer.getName());
        assertEquals("surname", customer.getSurname());
        assertEquals("mail@email.com", customer.getEmail());

    }

}