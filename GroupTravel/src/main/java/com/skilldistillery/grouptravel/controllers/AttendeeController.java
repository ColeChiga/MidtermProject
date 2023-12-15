package com.skilldistillery.grouptravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.AttendeeDao;
import com.skilldistillery.grouptravel.data.FamilyDAO;
import com.skilldistillery.grouptravel.data.FlightDAO;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.data.VacationDAO;
import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.Family;
import com.skilldistillery.grouptravel.entities.Flight;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;

import jakarta.servlet.http.HttpSession;

@Controller
public class AttendeeController {

	@Autowired
	AttendeeDao attendeeDAO;

	@Autowired
	UserDAO userDao;

	@Autowired
	VacationDAO vacationDao;

	@Autowired
	FamilyDAO familyDao;

	@Autowired
	FlightDAO flightDao;

	@RequestMapping(path = "attendee.do", method = RequestMethod.GET)
	public String getAttendee(HttpSession session, @RequestParam("vacationId") int vacationId, int userId) {
		if (session.getAttribute("sessionUser") != null) {
			session.setAttribute("sessionVacation", attendeeDAO.findVacationById(vacationId, userId));

			return "attendee";

		}
		return "account";

	}

	@RequestMapping(path = "createAttendee.do", method = RequestMethod.GET)
	public String createAttendeeGet(HttpSession session, @RequestParam("familyId") int familyId,
			@RequestParam("vacationId") int vacationId, Model model) {
		Family family = familyDao.findFamilyById(familyId);
		Vacation vacation = vacationDao.findVacationById(vacationId);
		List<Flight> flight = flightDao.findFlightByUserId(family.getUser().getId());
		// session.setAttribute("sessionFamily", family);
		model.addAttribute("family", family);
		model.addAttribute("vacation", vacation);
		model.addAttribute("attendee", vacation.getAttendees());
		model.addAttribute("flight", flight);
		return "createAttendee";
	}

	@RequestMapping(path = "createAttendee.do", method = RequestMethod.POST)
	public String createAttendeePost(HttpSession session, @RequestParam("userId") int userId,
			@RequestParam("vacationId") int vacationId, Attendee attendee, Model model,
			@RequestParam("createFlight") boolean flight) {
		User user = (User) session.getAttribute("sessionUser");
		Vacation vacation = vacationDao.findVacationById(vacationId);
		Attendee createAttendee = null;
		try {
			createAttendee = attendeeDAO.create(attendee, vacationId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (createAttendee == null) {

			model.addAttribute("createAttendee", createAttendee);
			model.addAttribute("vacation", vacation);
			refreshSessionUser(session);
		}
		if (flight) {
			return "createFlight";
		} else {
			return "redirect:vacation.do?vacationId=" + vacationId;
		}
	}

	@RequestMapping(path = "removeAttendee.do", method = RequestMethod.GET)
	public String removeAttendee(@RequestParam("userId") int userId, @RequestParam("vacationId") int vacationId,
			HttpSession session) {
		attendeeDAO.deleteById(userId, vacationId);
		refreshSessionUser(session);
		return "redirect:vacation.do?vacationId=" + vacationId;
	}

	public void refreshSessionUser(HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		user = userDao.authenticateUser(user.getUsername(), user.getPassword());
		if (user != null) {
			user.getFamilies().size();
			user.getVacations().size();
			user.getCreatedFamily().size();
			session.setAttribute("sessionUser", user);

		}

	}
}
