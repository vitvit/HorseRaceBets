package net.tarasyuk.horseracebets.controller;

import net.tarasyuk.horseracebets.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping
	public String users(Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "users";
	}

	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findUserWithBetsById(id));
		return "/userinfo";
	}

	@RequestMapping("/remove/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.removeUser(id);
		return "redirect:/users.html";
	}

}
