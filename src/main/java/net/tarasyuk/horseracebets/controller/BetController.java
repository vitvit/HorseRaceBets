package net.tarasyuk.horseracebets.controller;

import java.security.Principal;

import javax.validation.Valid;

import net.tarasyuk.horseracebets.data.Bet;
import net.tarasyuk.horseracebets.service.BetService;
import net.tarasyuk.horseracebets.service.HorseService;
import net.tarasyuk.horseracebets.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BetController {

	@Autowired
	private BetService betService;
	@Autowired
	private HorseService horseService;
	@Autowired
	private UserService userService;

	@ModelAttribute("bet")
	public Bet bet() {
		return new Bet();
	}

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("betList", betService.findBetsByUser(username));
		model.addAttribute("horseList", horseService.listHorse());
		model.addAttribute("user", userService.findUserWithBets(username));
		return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String addBet(Model model, @Valid @ModelAttribute("bet") Bet bet,
			BindingResult result, Principal principal) {

		if (result.hasErrors()) {
			return account(model, principal);
		}
		betService.addBet(bet, principal.getName());

		return "redirect:/account.html";
	}

	@RequestMapping("/bet/delete/{betId}")
	public String deleteBet(@PathVariable int betId) {
		Bet bet = betService.findBet(betId);
		betService.removeBet(bet);
		return "redirect:/account.html";
	}

}
