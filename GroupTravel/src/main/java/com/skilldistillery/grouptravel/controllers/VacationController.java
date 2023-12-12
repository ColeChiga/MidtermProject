package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.VacationDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class VacationController {
	
	@Autowired
	private VacationDAO vacationDao;
	
	@RequestMapping(path = "vacation.do", method = RequestMethod.GET)
	public String getVacation(HttpSession session,@RequestParam("vacationId") int id) {
		if (session.getAttribute("sessionUser") != null) {
			session.setAttribute("sessionVacation", vacationDao.findVacationByUserId(id));
	
			return "vacation";

		}
		return "account";

	}

}
