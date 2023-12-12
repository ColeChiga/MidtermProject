package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Vacation;

public interface VacationDAO {

	List<Vacation> findVacationByUserId(int id);

	Vacation create(Vacation vacation);

	Vacation update(int vacationId, Vacation vacation);

	boolean deleteById(int vacationId);

}
