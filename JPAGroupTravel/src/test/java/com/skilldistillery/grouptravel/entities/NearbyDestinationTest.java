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

class NearbyDestinationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private NearbyDestination nearbyDestination;

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
		NearbyDestinationId destId = new NearbyDestinationId();
		destId.setDestinationId(1);
		destId.setNearbyId(2);
//		destId.setDestinationId(1);
		nearbyDestination = em.find(NearbyDestination.class, destId);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		nearbyDestination = null;
	}

	@Test
	void test() {
		assertNotNull(nearbyDestination);
		assertEquals(2, nearbyDestination.getNearbyId().getId());
		assertEquals("Texas", nearbyDestination.getNearbyId().getName());
		assertEquals(1, nearbyDestination.getDestinationId().getId());
		assertEquals("Florida", nearbyDestination.getDestinationId().getName());
		
	}

}
