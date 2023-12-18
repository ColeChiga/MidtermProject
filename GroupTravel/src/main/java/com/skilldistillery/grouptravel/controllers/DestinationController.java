package com.skilldistillery.grouptravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.ActivityDAO;
import com.skilldistillery.grouptravel.data.DestinationDaoImpl;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.entities.Activity;
import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class DestinationController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private DestinationDaoImpl destinationDao;

	@Autowired
	private ActivityDAO activityDao;

	@RequestMapping(path = "individual.do")
	public String findDestinationById(Model model, @RequestParam("destinationId") int destinationId) {
		model.addAttribute("destination", destinationDao.findDestinationById(destinationId));
		return "individual";

	}

	@RequestMapping(path = "createActivity.do", method = RequestMethod.GET)
	public String addActivity(Model model, @RequestParam("destinationId") int destinationId) {
		List<Activity> addActivity = activityDao.findActivityByDestinationId(destinationId);
		System.out.println(addActivity.toString());
		Destination destination = destinationDao.findDestinationById(destinationId);

		model.addAttribute("destination", destination);
		model.addAttribute("activities", addActivity);

		return "createActivity";

	}

	@RequestMapping(path = "createDestinationActivity.do", method = RequestMethod.POST)
	public String addDestinationActivity(Model model, @RequestParam("destinationId") int destinationId, Activity activity) {
		Destination destination = destinationDao.findDestinationById(destinationId);
		Activity createdActivity = null;

		try {
			createdActivity = activityDao.create(activity, destinationId);
			destination.addActivity(createdActivity);
			createdActivity.addDestination(destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("destination", destination);
		model.addAttribute("activity", createdActivity);

		return "redirect:individual.do?destinationId=" + destinationId;

	}
	@RequestMapping(path = "updateDestinationActivity.do", method = RequestMethod.GET)
	public String updateDestinationActivityGet(Model model, @RequestParam("destinationId") int destinationId, @RequestParam("activityId") int activityId, Activity activity) {
		model.getAttribute("activity");
		Destination destination = destinationDao.findDestinationById(destinationId);
		Activity updateActivity = activityDao.findActivityId(activityId);
		model.addAttribute("destination", destination);
		model.addAttribute("activity", updateActivity);
		
		return "updateActivity";
		
	}
	@RequestMapping(path = "updateDestinationActivity.do", method = RequestMethod.POST)
	public String updateDestinationActivityPost(Model model, @RequestParam("destinationId") int destinationId, @RequestParam("activityId") int activityId, Activity activity) {
		model.getAttribute("activity");
		Activity updateActivity = activityDao.update(activityId, activity);
		model.addAttribute("activity", updateActivity);
		
		return "redirect:individual.do?destinationId=" + destinationId;
		
	}

	@RequestMapping(path = "removeDestinationActivity.do", method = RequestMethod.POST)
	public String removeVacationDestination(@RequestParam("destinationId") int destinationId,
			@RequestParam("activityId") int activityId, HttpSession session) {
		activityDao.deleteById(activityId, destinationId);
		return "redirect:individual.do?destinationId=" + destinationId;
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
