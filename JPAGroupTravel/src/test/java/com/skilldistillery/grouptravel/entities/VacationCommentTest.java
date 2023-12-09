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

class VacationCommentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private VacationComment vacationComment;

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
		vacationComment = em.find(VacationComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		vacationComment = null;
	}

	@Test
	void test() {
		assertNotNull(vacationComment);
		assertEquals("meh", vacationComment.getComment());
	}

}
