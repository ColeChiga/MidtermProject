package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.entities.Address;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

	@Autowired
	private UserDAO userDao;

	@RequestMapping(path = { "account.do" })
	public String account(HttpSession session) {
		if (session.getAttribute("sessionUser") != null) {
			
			return "account";
		} else {
			return "login";
		}

	}
	
	@RequestMapping(path = { "createAccount.do" })
	public String createAccount(HttpSession session) {
		if (session.getAttribute("sessionUser") == null) {
			Address createAddress = null;
			session.setAttribute("sessionAddress", createAddress);
			return "createAccount";
		} else {
			return "updateAccount";
		}

	}
}
