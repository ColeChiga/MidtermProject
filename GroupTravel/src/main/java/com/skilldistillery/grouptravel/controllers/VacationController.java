package com.skilldistillery.grouptravel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.FamilyDAO;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.data.VacationCommentDao;
import com.skilldistillery.grouptravel.data.VacationDAO;
import com.skilldistillery.grouptravel.data.VacationDestinationDAO;
import com.skilldistillery.grouptravel.entities.Family;
import com.skilldistillery.grouptravel.entities.User;
import com.skilldistillery.grouptravel.entities.Vacation;
import com.skilldistillery.grouptravel.entities.VacationComment;
import com.skilldistillery.grouptravel.entities.VacationDestination;

import jakarta.servlet.http.HttpSession;

@Controller
public class VacationController {

	@Autowired
	private VacationDAO vacationDao;
	@Autowired
	private FamilyDAO familyDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private VacationDestinationDAO vacationDestinationDao;

	@Autowired
	private VacationCommentDao vacationCommentDao;

	@RequestMapping(path = "vacation.do", method = RequestMethod.GET)
	public String getVacation(HttpSession session, @RequestParam("vacationId") int id, Model model, VacationDestination vd) {
		
		Vacation vacation = vacationDao.findVacationById(id);
		if (!((User)session.getAttribute("sessionUser")).getFamilies().contains(vacation.getFamily())) {
			return "redirect:family.do?familyId="+vacation.getFamily().getId();
		}
		if (session.getAttribute("sessionUser") != null) {
			// session.setAttribute("sessionVacation", vacationDao.findVacationById(id));
			model.addAttribute("vacation", vacation);
			model.addAttribute("destinations", vacationDestinationDao.findVacationDestinationByVacationId(id));
			return "vacation";

		}
		return "login";

	}

	@RequestMapping(path = "createVacation.do", method = RequestMethod.GET)
	public String createVacationGet(HttpSession session, User user, Vacation vacation) {
		user = (User) session.getAttribute("sessionUser");

		return "createVacation";
	}

	@RequestMapping(path = "createVacation.do", method = RequestMethod.POST)
	public String createVacationPost(HttpSession session, @RequestParam("userId") int id,
			@RequestParam("familyId") int familyId, User user, Vacation vacation) {
		user = (User) session.getAttribute("sessionUser");
		Family family = familyDao.findFamilyById(familyId);
		vacation.setFamily(family);
		vacation.setUser(user);
		Vacation createVacation = vacationDao.create(vacation);
		session.setAttribute("sessionVacation", createVacation);
		refreshSessionUser(session);
		return "redirect:vacation.do?vacationId="+createVacation.getId();
	}

	@RequestMapping(path = "updateVacation.do", method = RequestMethod.GET)
	public String updateVacationGet(HttpSession session, @RequestParam("vacationId") int vacationId,
			Vacation vacation) {
		User user = (User) session.getAttribute("sessionUser");
		vacation = vacationDao.findVacationById(vacationId);
		session.setAttribute("sessionVacation", vacation);
		return "updateVacation";
	}

	@RequestMapping(path = "updateVacation.do", method = RequestMethod.POST)
	public String updateVacationPost(HttpSession session, @RequestParam("vacationId") int vacationId,
			Vacation vacation) {
		User user = (User) session.getAttribute("sessionUser");

		Vacation updatedVacay = vacationDao.update(vacationId, vacation);

		session.setAttribute("sessionVacation", updatedVacay);
		refreshSessionUser(session);
		return "redirect:vacation.do?vacationId=" + vacationId;
	}

	@RequestMapping(path = "removeUser.do", method = RequestMethod.GET)
	public String removerUserFromVacation(HttpSession session, @RequestParam("vacationId") int vacationId,
			Vacation vacation, User user) {
		user = (User) session.getAttribute("sessionUser");
		session.removeAttribute("sessionUser");

		return null;

	}

	@RequestMapping(path = "createVacationComment.do", method = RequestMethod.GET)
	public String createVacationComment(HttpSession session, @RequestParam("vacationId") int vacationId,
			@RequestParam("comment") String comment, Vacation vacation, User user, Model model) {
		user = (User) session.getAttribute("sessionUser");
		vacation = vacationDao.findVacationById(vacationId);
		try {
			VacationComment createVacationComment = vacationCommentDao.create(vacation, user, comment);
			model.addAttribute("createVacationComment", createVacationComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		refreshSessionUser(session);
		return "redirect:vacation.do?vacationId=" + vacationId;

	}

	@RequestMapping(path = "removeComment.do", method = RequestMethod.POST)
	public String removeComment(HttpSession session, @RequestParam("vacationId") int vacationId, @RequestParam ("commentId") int commentId,
			Vacation vacation, User user, Model model) {
		user = (User) session.getAttribute("sessionUser");
		vacationCommentDao.deleteById(commentId);
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
