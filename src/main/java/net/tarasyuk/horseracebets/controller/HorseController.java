package net.tarasyuk.horseracebets.controller;

import javax.validation.Valid;

import net.tarasyuk.horseracebets.data.Horse;
import net.tarasyuk.horseracebets.service.HorseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/horsemanager")
public class HorseController {
	@Autowired
	HorseService horseService;

	@ModelAttribute("horse")
	public Horse newHorse() {
		return new Horse();
	}

	@RequestMapping
	public String listHorse(Model model) {
		model.addAttribute("horseList", horseService.listHorse());
		return "/horsemanager";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addHorse(Model model,
			@Valid @ModelAttribute("horse") Horse horse, BindingResult result) {
		if (result.hasErrors()) {
			return listHorse(model);
		}
		horseService.addHorse(horse);
		return "redirect:/horsemanager.html";
	}

	@RequestMapping("/delete/{horseId}")
	public String deleteHorse(@PathVariable("horseId") Integer horseId) {
		horseService.removeHorse(horseId);
		return "redirect:/horsemanager.html";
	}

	@RequestMapping("/{id}")
	public String horseInfo(Model model, @PathVariable int id) {
		model.addAttribute("horse", horseService.findBetsByHorse(id));
		return "/horseinfo";

	}

}