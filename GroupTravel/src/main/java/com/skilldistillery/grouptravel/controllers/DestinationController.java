package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.DestinationDaoImpl;

@Controller
public class DestinationController {

	@Autowired
	private DestinationDaoImpl destinationDao;
	
	@RequestMapping(path = "individual.do" )
	public String findDestinationById(Model model, @RequestParam("destinationId") int destinationId) {
		model.addAttribute("destination", destinationDao.findDestinationById(destinationId));
		return "individual";
		
	}
	
}
