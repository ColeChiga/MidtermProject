package com.skilldistillery.grouptravel.data;

import java.util.List;

import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.AttendeeId;
import com.skilldistillery.grouptravel.entities.Vacation;

public interface AttendeeDao {

	public List<Vacation> findAll();

	public Vacation findVacationById(int vacationId, int userId);

	public Attendee create(Attendee attendee, int vacationId, int userId);

	Attendee update(AttendeeId id, Attendee attendee);

	boolean deleteById(int userId, int vacationId);

}
