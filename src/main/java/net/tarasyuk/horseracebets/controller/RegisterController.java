package net.tarasyuk.horseracebets.controller;

import javax.validation.Valid;

import net.tarasyuk.horseracebets.authorization.User;
import net.tarasyuk.horseracebets.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/registration")
public class RegisterController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User user() {
		return new User();
	}

	@RequestMapping
	public String showRegister() {
		return "/registration";

	}

	@RequestMapping("/registration/")
	public String homeManager() {
		return "redirect:/index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/registration";
		}
		userService.addUser(user);
		return "redirect:/registration.html?success=true";
	}

	@RequestMapping("/checkusername")
	@ResponseBody
	public String checkUsername(@RequestParam String username) {

		Boolean checkUsername = userService.findUser(username) == null;
		return checkUsername.toString();
	}
}