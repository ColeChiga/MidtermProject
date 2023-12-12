package com.skilldistillery.grouptravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.grouptravel.data.AddressDao;
import com.skilldistillery.grouptravel.data.UserDAO;
import com.skilldistillery.grouptravel.entities.Address;
import com.skilldistillery.grouptravel.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private AddressDao addressDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		model.addAttribute("SMOKETEST", userDao.authenticateUser("admin", "12345"));
		return "home";

	}

	@RequestMapping(path = "createAccount.do", method = RequestMethod.POST)
	public String createAccount(HttpSession session, User user, Address address) {
		Address createAddress = addressDao.create(address);
		session.setAttribute("sessionAddress", createAddress);
		user.setAddress(createAddress);
		User createUser = userDao.create(user);
		session.setAttribute("sessionUser", createUser);
		if (createUser == null) {
			return "createAccount";
		} else {
			return "account";
		}

	}
	
	@RequestMapping(path = "updateAccount.do", method = RequestMethod.POST)
	public String updateAccount(HttpSession session, @RequestParam("userId")int userId, User user, @RequestParam("addressId")int addressId, Address address) {
		Address updateAddress = addressDao.update(addressId, address);
		user.setAddress(updateAddress);
		
		session.setAttribute("sessionAddress", updateAddress);
		User updateUser = userDao.update(userId, user);
		session.setAttribute("sessionUser", updateUser);
		if (updateUser == null) {
			return "updateAccount";
		} else {
			return "account";
		}
		
	}

//	@RequestMapping(path = "updateAccount.do", method = RequestMethod.POST)
//	public String updateAccount(HttpSession session,User user, Address address) {
//		session.setAttribute("sessionAddress", addressDao.update(address.getId(), address));
//		user.setAddress(address);
//		session.setAttribute("sessionUser", userDao.update(user.getId(), user));
//		return "account";
//	}

}
