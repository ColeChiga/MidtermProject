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

class ActivityTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Activity activity;

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
		activity = em.find(Activity.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		activity = null;
	}

	@Test
	void test() {
		assertNotNull(activity);
		assertEquals("family trip", activity.getName());
	}
	@Test
	void test_activity_destination_connection() {
		assertNotNull(activity);
		assertEquals(1, activity.getDestination().size());
		assertEquals("Florida", activity.getDestination().get(0).getName());
	}

}
