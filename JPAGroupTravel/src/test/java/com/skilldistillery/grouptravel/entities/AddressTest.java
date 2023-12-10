package com.skilldistillery.grouptravel.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class AddressTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address address1;
	private Address address2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAGroupTravel");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		address1 = em.find(Address.class, 1);
		address2 = em.find(Address.class, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		address1 = null;
		address2 = null;
	}

	@Test
	void test() {
		assertNotNull(address2);
		assertEquals("123 magic st", address2.getStreet());
	}

	@Test
	void test_location_address_connection() {
		assertNotNull(address2);
		assertEquals(1, address2.getLocation().size());
		assertEquals("Disney World", address2.getLocation().get(0).getName());
	}
	@Test
	void test_user_address_connection() {
		assertNotNull(address1);
		assertEquals(1, address1.getUser().size());
		assertEquals("joe", address1.getUser().get(0).getFirstName());
		assertEquals("snuffy", address1.getUser().get(0).getLastName());
	}
	
}
