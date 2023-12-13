package com.skilldistillery.grouptravel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.FamilyDAO;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.entities.Family;
import com.skilldistillery.grouptravel.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class FamilyController {

	@Autowired
	private FamilyDAO familyDao;

	@Autowired
	private UserDAO userDao;

	@RequestMapping(path = "family.do", method = RequestMethod.GET)
	public String getFamily(HttpSession session, @RequestParam("familyId") int id) {
		if (session.getAttribute("sessionUser") != null) {
			session.setAttribute("sessionFamily", familyDao.findFamilyByUserId(id));

			return "family";

		}
		return "account";

	}

	@RequestMapping(path = "createFamily.do", method = RequestMethod.GET)
	public String createFamilyGet(HttpSession session,@RequestParam("userId")int id, User user, Family family) {
		user = (User) session.getAttribute("sessionUser");
		family.setUser(user);
		Family createFamily = familyDao.create(family);
		List<Family> listFam = new ArrayList<>();
		listFam.add(createFamily);
		session.setAttribute("sessionFamily", createFamily);
		user.setCreatedFamily(listFam);
			return "createFamily";
	}
	
	@RequestMapping(path = "createFamily.do", method = RequestMethod.POST)
	public String createFamilyPost(HttpSession session, @RequestParam("familyId")int id, User user,Family family) {
	
		user = (User) session.getAttribute("sessionUser");
		userDao.update(user.getId(),user);
		Family createFamily = familyDao.update(id,family);
		List<Family> listFam = new ArrayList<>();
		listFam.add(createFamily);
		session.setAttribute("sessionFamily", createFamily);
		user.setCreatedFamily(listFam);
		return"newFamily";
	}
}
