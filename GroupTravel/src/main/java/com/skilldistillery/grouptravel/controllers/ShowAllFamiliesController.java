package com.skilldistillery.grouptravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.grouptravel.data.FamilyDAOImpl;
import com.skilldistillery.grouptravel.entities.Family;

@Controller
public class ShowAllFamiliesController {


	@Autowired
	private FamilyDAOImpl familyDAO;

	@RequestMapping(path = "showAllFamilies.do", method = RequestMethod.GET)
	public String showAllFamilies(Model model) {
		List<Family> familyList = familyDAO.findAll();
        model.addAttribute("familyList", familyList);
		return "showAllFamilies";
		
	}

}
