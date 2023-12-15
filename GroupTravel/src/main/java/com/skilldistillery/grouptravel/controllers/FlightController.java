package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.FlightDAO;
import com.skilldistillery.grouptravel.entities.Flight;

import jakarta.servlet.http.HttpSession;

@Controller
public class FlightController {

	@Autowired
	private FlightDAO flightDao;

	@RequestMapping(path = "createFlight.do", method = RequestMethod.POST)
	public String createAccount(HttpSession session, Flight flight, Model model,
			@RequestParam("vacationId") int vacationId, @RequestParam("userId") int userId) {
		Flight createFlight = flightDao.create(flight, userId, vacationId);
		model.addAttribute("flight", createFlight);
		
		if (createFlight == null) {
			return "createFlight";
		} else {
			return "redirect:vacation.do?vacationId=" + vacationId ;
		}

	}

	@RequestMapping(path = "updateFlight.do", method = RequestMethod.POST)
	public String updateAccount(HttpSession session, @RequestParam("userId") int flightId, Flight flight) {
		Flight updateFlight = flightDao.update(flightId, flight);
		session.setAttribute("sessionFlight", updateFlight);
		if (updateFlight == null) {
			return "updateAccount";
		} else {
			return "account";
		}

	}

	@RequestMapping(path = "deleteFlight.do", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam("userId") int userId, HttpSession session) {
		session.removeAttribute("sessionFlight");
		return "home";
	}

}
