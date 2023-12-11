package com.skilldistillery.grouptravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.grouptravel.data.DestinationDaoImpl;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.entities.Destination;

@Controller
public class ShowAllDestinationsController {


	@Autowired
	private DestinationDaoImpl destinationDao;

	@RequestMapping(path = "showAllDestinations.do", method = RequestMethod.GET)
	public String showAllDestinations(Model model) {
		List<Destination> destinationList = destinationDao.findAll();
        model.addAttribute("destinationList", destinationList);
		return "showAllDestinations";
		
	}

}
