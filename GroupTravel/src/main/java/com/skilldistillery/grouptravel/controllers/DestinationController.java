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
import com.skilldistillery.grouptravel.entities.Activity;
import com.skilldistillery.grouptravel.entities.Destination;

@Controller
public class DestinationController {

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
		Destination destination = destinationDao.findDestinationById(destinationId);
		Activity activity = addActivity.get(0);

		model.addAttribute("destination", destination);
		model.addAttribute("activity", activity);

		return "createActivity";

	}

	@RequestMapping(path = "createDestinationActivity.do", method = RequestMethod.POST)
	public String addDestinationActivity(Model model, @RequestParam("destinationId") int destinationId,
			Activity activity) {
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

}
