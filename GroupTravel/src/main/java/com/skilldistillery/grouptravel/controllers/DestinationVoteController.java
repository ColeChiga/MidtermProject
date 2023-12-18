package com.skilldistillery.grouptravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.AttendeeDao;
import com.skilldistillery.grouptravel.data.DestinationDAO;
import com.skilldistillery.grouptravel.data.DestinationVoteDao;
import com.skilldistillery.grouptravel.data.FamilyDAO;
import com.skilldistillery.grouptravel.data.FlightDAO;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.data.VacationDAO;
import com.skilldistillery.grouptravel.data.VacationDestinationDAO;
import com.skilldistillery.grouptravel.entities.Attendee;
import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.DestinationVote;
import com.skilldistillery.grouptravel.entities.Family;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationDestination;

import jakarta.servlet.http.HttpSession;

@Controller
public class DestinationVoteController {

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

	@Autowired
	DestinationDAO destinationDao;

	@Autowired
	VacationDestinationDAO vacationDestinationDao;

	@Autowired
	DestinationVoteDao destinationVoteDao;

	@RequestMapping(path = "destinationVote.do", method = RequestMethod.GET)
	public String getVacationDestination(HttpSession session, Model model,
			@RequestParam("destinationId") int vacationId, int userId) {
		if (session.getAttribute("sessionUser") != null) {
			model.addAttribute("vacation", vacationDao.findVacationById(vacationId));
			model.addAttribute("destinations", destinationDao.findAll());

			return "attendee";

		}
		return "account";

	}

	@RequestMapping(path = "createDestinationVote.do", method = RequestMethod.GET)
	public String createDestinationVoteGet(HttpSession session, @RequestParam("familyId") int familyId,
			@RequestParam("vacationId") int vacationId, Model model) {
		Family family = familyDao.findFamilyById(familyId);
		Vacation vacation = vacationDao.findVacationById(vacationId);
		List<Destination> destinations = destinationDao.findAll();
		model.addAttribute("family", family);
		model.addAttribute("vacation", vacation);
		model.addAttribute("destinations", destinations);

		return "redirect:vacation.do?vacationId=" + vacationId;
	}

	@RequestMapping(path = "createDestinationVote.do", method = RequestMethod.POST)
	public String createDestinationVote(@RequestParam("vacationId") int vacationId, @RequestParam("vote") boolean vote,
			@RequestParam("voteRemarks") String voteRemarks, @RequestParam("destinationId") int destinationId,
			Model model, HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		DestinationVote destinationVote = destinationVoteDao.create(vote, voteRemarks, vacationId, user.getId(),
				destinationId);
		model.addAttribute("vote", destinationVote);
		System.out.println(destinationVote.getAttendee());
		return "redirect:vacation.do?vacationId=" + vacationId;
	}

	@RequestMapping(path = "removeDestinationVote.do", method = RequestMethod.POST)
	public String removeVacationDestination(@RequestParam("destinationId") int destinationId,
			@RequestParam("vacationId") int vacationId, HttpSession session) {
		destinationVoteDao.deleteById(vacationId);
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
