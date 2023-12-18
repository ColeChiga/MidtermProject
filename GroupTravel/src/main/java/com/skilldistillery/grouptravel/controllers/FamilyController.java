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
		return "login";

	}

	@RequestMapping(path = "createFamily.do", method = RequestMethod.GET)
	public String createFamilyGet(HttpSession session, @RequestParam("userId") int id, User user, Family family) {
		user = (User) session.getAttribute("sessionUser");
		family.setUser(user);
		family.setName("placeholder");
		Family createFamily = familyDao.create(family);
		List<Family> listFam = new ArrayList<>();
		listFam.add(createFamily);
		session.setAttribute("sessionFamily", createFamily);
		user.setCreatedFamily(listFam);
		return "createFamily";
	}

	@RequestMapping(path = "createFamily.do", method = RequestMethod.POST)
	public String createFamilyPost(HttpSession session, @RequestParam("familyId") int id, User user, Family family) {

		user = (User) session.getAttribute("sessionUser");
		userDao.update(user.getId(), user);
		Family createFamily = familyDao.update(id, family, user);
		List<Family> listFam = new ArrayList<>();
		listFam.add(createFamily);
		user.setCreatedFamily(listFam);
		user.addFamily(createFamily);
		session.setAttribute("sessionUser", user);
		session.setAttribute("sessionFamily", createFamily);
		return "newFamily";
	}

	@RequestMapping(path = "updateFamily.do", method = RequestMethod.POST)
	public String updateFamilyUsers(HttpSession session, User user, Family family) {
		user = (User) session.getAttribute("sessionUser");
		List<Family>listFamily = (List<Family>) session.getAttribute("sessionFamily");
		family = listFamily.get(0);
		userDao.update(user.getId(), user);
		user.addFamily(family);
		familyDao.update(family.getId(), family, user);
		session.setAttribute("sessionUser", user);
		session.setAttribute("family", family);
		session.setAttribute("sessionFamily", family);
		return "account";

	}
	@RequestMapping(path = "updateFamilyValues.do", method = RequestMethod.GET)
	public String createFamilyValuesGet(HttpSession session, User user, Family family) {
		user = (User) session.getAttribute("sessionUser");
		List<Family>listFamily = (List<Family>) session.getAttribute("sessionFamily");
		family = listFamily.get(0);
		userDao.update(user.getId(), user);
		user.addFamily(family);
		familyDao.update(family.getId(), family, user);
		session.setAttribute("sessionUser", user);
		session.setAttribute("family", family);
		session.setAttribute("sessionFamily", family);
	
		
		return "updateFamily";
		}
	
	@RequestMapping(path = "updateFamilyValues.do", method = RequestMethod.POST)
	public String createFamilyValuesPost(HttpSession session, @RequestParam("familyId") int id, User user, Family family) {

		user = (User) session.getAttribute("sessionUser");
		userDao.update(user.getId(), user);
		Family createFamily = familyDao.update(id, family, user);
		List<Family> listFam = new ArrayList<>();
		listFam.add(createFamily);
		user.setCreatedFamily(listFam);
		user.addFamily(createFamily);
		session.setAttribute("sessionUser", user);
		session.setAttribute("sessionFamily", createFamily);
		return "newFamily";
	}
	
	@RequestMapping(path = "deleteFamily.do", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam("familyId") int familyId, HttpSession session) {
		familyDao.deleteById(familyId);
			refreshSessionUser(session);
		return "redirect:account.do";
	}
	
	public void refreshSessionUser(HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		user = userDao.authenticateUser(user.getUsername(), user.getPassword());
		if(user != null) {
			user.getFamilies().size();
			user.getVacations().size();
			user.getCreatedFamily().size();
			session.setAttribute("sessionUser", user);
			
		}
		
	}
}
