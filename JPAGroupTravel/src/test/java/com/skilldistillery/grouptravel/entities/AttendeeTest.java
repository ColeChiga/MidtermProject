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

class AttendeeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Attendee attendee;

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
		AttendeeId aid = new AttendeeId();
		aid.setUserId(1);
		aid.setVacationId(1);
		attendee = em.find(Attendee.class, aid);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		attendee = null;
	}

	@Test
	void test_list_of_destination_votes() {
		assertNotNull(attendee);
		assertNotNull(attendee.getDestinationVotes());
		assertTrue(attendee.getDestinationVotes().size() > 0);
	}
	@Test
	void test() {
		assertNotNull(attendee);
		assertEquals(1, attendee.getLocation());
		assertTrue (attendee.isConfirmed());
		
	}

}
