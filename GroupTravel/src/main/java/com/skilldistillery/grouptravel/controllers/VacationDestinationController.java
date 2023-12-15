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
import com.skilldistillery.grouptravel.data.FamilyDAO;
import com.skilldistillery.grouptravel.data.FlightDAO;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.data.VacationDAO;
import com.skilldistillery.grouptravel.data.VacationDestinationDAO;
import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.Family;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationDestination;

import jakarta.servlet.http.HttpSession;

@Controller
public class VacationDestinationController {

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
	
	@RequestMapping(path = "vacationDestination.do", method = RequestMethod.GET)
	public String getVacationDestination(HttpSession session, Model model, @RequestParam("vacationId") int vacationId, int userId) {
		if (session.getAttribute("sessionUser") != null) {
			model.addAttribute("vacation", vacationDao.findVacationById(vacationId));
			model.addAttribute("destinations", destinationDao.findAll());

			return "attendee";

		}
		return "account";

	}

	@RequestMapping(path = "createVacationDestination.do", method = RequestMethod.GET)
	public String createVacationDestinationGet(HttpSession session, @RequestParam("familyId") int familyId,
			@RequestParam("vacationId") int vacationId, Model model) {
		Family family = familyDao.findFamilyById(familyId);
		Vacation vacation = vacationDao.findVacationById(vacationId);
		List<Destination> destinations = destinationDao.findAll();
		// session.setAttribute("sessionFamily", family);
		model.addAttribute("family", family);
		model.addAttribute("vacation", vacation);
		model.addAttribute("destinations", destinations);
		
		
		return "createVacationDestination";
	}

	@RequestMapping(path = "createVacationDestination.do", method = RequestMethod.POST)
	public String createVacationDestinationPost(HttpSession session, @RequestParam("vacationId") int vacationId, @RequestParam("remarks") String remarks, Destination destination, Model model) {
		User user = (User) session.getAttribute("sessionUser");
		Vacation vacation = vacationDao.findVacationById(vacationId);
		Destination createDestination = null;
		try {
			createDestination = destinationDao.create(destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		VacationDestination createVD = null;
		try {
			createVD = vacationDestinationDao.create(vacation, createDestination, user, remarks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			model.addAttribute("createDestination", createVD);
			model.addAttribute("createDestination", createDestination);
			model.addAttribute("vacation", vacation);
			refreshSessionUser(session);
		
		
			return "redirect:vacation.do?vacationId=" + vacationId;
		
	}
	@RequestMapping(path = "addVacationDestination.do", method = RequestMethod.POST)
	public String addVacationDestinationPost(HttpSession session, @RequestParam("vacationId") int vacationId, @RequestParam("remarks") String remarks,  @RequestParam("destinationId")int destinationId, Model model) {
		User user = (User) session.getAttribute("sessionUser");
		Vacation vacation = vacationDao.findVacationById(vacationId);
		Destination addDestination = destinationDao.findDestinationById(destinationId);
		VacationDestination createVD = null;
		try {
			createVD = vacationDestinationDao.create(vacation, addDestination, user, remarks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("createDestination", createVD);
		model.addAttribute("createDestination", addDestination);
		model.addAttribute("vacation", vacation);
		refreshSessionUser(session);
		
		
		return "redirect:vacation.do?vacationId=" + vacationId;
		
	}

	@RequestMapping(path = "removeVacationDestination.do", method = RequestMethod.GET)
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
