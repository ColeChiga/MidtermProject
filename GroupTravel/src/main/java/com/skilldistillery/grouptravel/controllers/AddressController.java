package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.grouptravel.data.UserDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddressController {

	@Autowired
	private UserDAO userDao;

	@RequestMapping(path = { "Address.do" })
	public String address(HttpSession session) {
		if (session.getAttribute("sessionUser") != null) {
			return "account";
		} else {
			return "login";
		}

	}
}
