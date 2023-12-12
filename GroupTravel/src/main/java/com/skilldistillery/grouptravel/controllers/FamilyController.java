package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.FamilyDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class FamilyController {
	
	@Autowired
	private FamilyDAO familyDao;
	
	@RequestMapping(path = "family.do", method = RequestMethod.GET)
	public String getFamily(HttpSession session,@RequestParam("familyId") int id) {
		if (session.getAttribute("sessionUser") != null) {
			session.setAttribute("sessionFamily", familyDao.findFamilyByUserId(id));
	
			return "family";

		}
		return "account";

	}

}
