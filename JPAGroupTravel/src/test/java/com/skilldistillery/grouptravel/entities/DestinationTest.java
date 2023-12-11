package com.skilldistillery.grouptravel.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class DestinationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Destination destination;

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
		destination = em.find(Destination.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		destination = null;
	}

	@Test
	void test() {
		assertNotNull(destination);
		assertEquals("Florida", destination.getName());
	}

	@Test
	void test_activity_destination_connection() {
		assertNotNull(destination);
		assertEquals(1, destination.getActivity().size());
		assertEquals("family trip", destination.getActivity().get(0).getName());
	}
	
	@Test
	void test_location_destination_connection() {
		assertNotNull(destination);
		assertEquals(1, destination.getLocation().size());
		assertEquals("Disney World", destination.getLocation().get(0).getName());
	}
	@Test
	void test_vacationDestination_destination_connection() {
		assertNotNull(destination);
		assertEquals(1, destination.getVacationDestination().size());
		assertEquals("meh", destination.getVacationDestination().get(0).getRemarks());
	}
	@Test
	void test_nearbyDestination_destination_connection() {
		assertNotNull(destination);
		assertNotNull(destination.getNearbyDestination());
		
		assertEquals(1, destination.getNearbyDestination().size());
		assertEquals(2, destination.getNearbyDestination().get(0).getNearbyId().getId());
		
	}
	
}
