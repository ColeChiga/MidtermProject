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

class DestinationVoteTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private DestinationVote destinationVote;

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
		DestinationVoteId div = new DestinationVoteId();
		div.setAttendeeUserId(1);
		div.setAttendeeVacationId(1);
		div.setDestinationDestinationId(1);
		div.setDestinationVacationId(1);
		destinationVote = em.find(DestinationVote.class, div);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		destinationVote = null;
	}

	@Test
	void test() {
		assertNotNull(destinationVote);
		assertEquals("yay", destinationVote.getVoteRemarks());
		assertTrue (destinationVote.getVote());
		
	}

}
