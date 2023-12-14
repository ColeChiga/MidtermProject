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
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.data.VacationDAO;
import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.Family;
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
		// session.setAttribute("sessionFamily", family);
		model.addAttribute("family", family);
		model.addAttribute("vacation", vacation);
		return "createAttendee";
	}

	@RequestMapping(path = "createAttendee.do", method = RequestMethod.POST)
	public String createAttendeePost(HttpSession session, @RequestParam("userId") int userId,
			@RequestParam("vacationId") int vacationId, Attendee attendee, Model model) {
		User user = (User) session.getAttribute("sessionUser");
		Vacation vacation = vacationDao.findVacationById(vacationId);
		vacation.setUser(user);
//		List<Attendee> attendees = vacation.getAttendees();
//		attendees.add(attendee);
//		vacation.setAttendees(attendees);
		Attendee createAttendee = attendeeDAO.create(attendee, vacationId, userId);
		model.addAttribute("createAttendee", createAttendee);
		model.addAttribute("vacation", vacation);
//		session.setAttribute("sessionAttendee", createAttendee);
//		session.setAttribute("sessionVacation", vacation);
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
