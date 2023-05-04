package com.smartcontact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontact.dao.UserRepository;
import com.smartcontact.entities.User;
import com.smartcontact.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-smart contact manager");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About-smart contact manager");
		return "about";
	}

	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("title", "Register-smart contact manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	// registering handler

	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {

		try {

			if (!agreement) {
				System.out.println("not agreed");
				//throw new Exception("Not agreed the terms condiiton");
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("img.png");

			System.out.println("Agreement- " + agreement);
			System.out.println("User- " + user);

			User result = this.userRepository.save(user);
			model.addAttribute("user", new User());

			session.setAttribute("message", new Message("Succesfully registered !!", "alert-success"));
			return "signup";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong !!" + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}
}
