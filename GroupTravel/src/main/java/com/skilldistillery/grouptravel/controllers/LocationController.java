package com.skilldistillery.grouptravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.AddressDao;
import com.skilldistillery.grouptravel.data.DestinationDAO;
import com.skilldistillery.grouptravel.data.LocationCategoryDAO;
import com.skilldistillery.grouptravel.data.LocationDAO;
import com.skilldistillery.grouptravel.data.VacationDestinationDAO;
import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.Destination;
import com.skilldistillery.grouptravel.entities.Location;
import com.skilldistillery.grouptravel.entities.LocationCategory;

import jakarta.servlet.http.HttpSession;

@Controller
public class LocationController {

	@Autowired
	private LocationDAO locationDao;
	@Autowired
	private DestinationDAO destinationDao;
	@Autowired
	private VacationDestinationDAO vacationDestinationDao;;
	@Autowired
	private LocationCategoryDAO locationCategoryDao;
	@Autowired
	private AddressDao addressDao;

	@RequestMapping(path = "showAllLocations.do", method = RequestMethod.GET)
	public String allLocations(Model model) {
		List<Location> location = locationDao.findAll();
		model.addAttribute("locationList", location);

		return "showAllLocations";
	}

	@RequestMapping(path = "individualLocation.do", method = RequestMethod.GET)
	public String allLocations(Model model, @RequestParam("locationId") int locationId) {
		Location location = locationDao.findLocationById(locationId);
		model.addAttribute("location", location);

		return "individualLocation";
	}

	@RequestMapping(path = "createLocation.do", method = RequestMethod.GET)
	public String createLocationGet(HttpSession session, Model model, @RequestParam("vacationId") int vacationId) {
		if (session.getAttribute("sessionUser") != null) {
			model.addAttribute("categoryList", locationCategoryDao.findAll());
			model.addAttribute("vacationId", vacationId);
			if (vacationId == -1) {
				model.addAttribute("destinations", destinationDao.findAll());
			} else {
				model.addAttribute("destinations",
						vacationDestinationDao.findVacationDestinationByVacationId(vacationId));
			}
			return "createLocation";
		} else {
			return "login";
		}
	}

	@RequestMapping(path = "createLocation.do", method = RequestMethod.POST)
	public String createLocationPost(HttpSession session, @RequestParam("destinationId") int destinationId,
			Location location, LocationCategory category, Address address, Model model,
			@RequestParam("vacationId") int vacationId, @RequestParam("categoryDescription") String catDesc,
			@RequestParam("locationDescription") String locDesc, @RequestParam("categoryName") String catName,
			@RequestParam("locationName") String locName) {

		category.setDescription(catDesc);
		location.setDescription(locDesc);
		category.setName(catName);
		location.setName(locName);

		address = addressDao.create(address);
		category = locationCategoryDao.create(category);

		location.setAddress(address);
		location.setCategory(category);
		Destination destination = destinationDao.findDestinationById(destinationId);
		location.setDestination(destination);

		Location createLocation = locationDao.create(location);
		model.addAttribute("flight", createLocation);

		if (createLocation == null) {
			return "createLocation";
		} else if (vacationId != -1) {
			return "redirect:vacation.do?vacationId=" + vacationId;
		} else {
			return "redirect:individualLocation.do?locationId=" + createLocation.getId();
		}

	}

	@RequestMapping(path = "updateLocation.do", method = RequestMethod.POST)
	public String updateAccount(HttpSession session, @RequestParam("userId") int locationId, Location location,
			@RequestParam("vacationId") int vacationId) {
		Location updateLocation = locationDao.update(location, locationId);
		session.setAttribute("sessionFlight", updateLocation);
		if (updateLocation == null) {
			return "updateLocation";
		} else {
			return "redirect:vacation.do?vacationId=" + vacationId;
		}

	}

	@RequestMapping(path = "deleteLocation.do", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam("locationId") int locationId, HttpSession session) {
		locationDao.delete(locationId);
		return "home";
	}

}
