package com.skilldistillery.grouptravel.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class VacationDestinationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private VacationDestination vacationDestination;

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
		VacationDestinationId vdi = new VacationDestinationId();
		vdi.setVacationId(1);
		vdi.setDestinationId(1);
		vacationDestination = em.find(VacationDestination.class, vdi);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		vacationDestination = null;
	}

	@Test
	void test_list_of_destination_votes() {
		assertNotNull(vacationDestination);
		assertNotNull(vacationDestination.getDestinationVotes());
		assertTrue(vacationDestination.getDestinationVotes().size() > 0);
	}

	@Test
	void test() {
		assertNotNull(vacationDestination);
		assertEquals(1, vacationDestination.getUser().getId());
		assertEquals("meh", vacationDestination.getRemarks());

	}

	@Test
	void test_vacaDest_Destination() {
		assertNotNull(vacationDestination);
		assertEquals(1, vacationDestination.getDestination().getId());
		assertEquals("Orlando", vacationDestination.getDestination().getName());
	}

}
