package net.tarasyuk.horseracebets.controller;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import javax.validation.Valid;

import net.tarasyuk.horseracebets.data.Horse;
import net.tarasyuk.horseracebets.data.Racing;
import net.tarasyuk.horseracebets.service.HorseService;
import net.tarasyuk.horseracebets.service.RacingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/racing")
public class RacingController {

	@Autowired
	RacingService racingService;
	@Autowired
	HorseService horseService;

	@RequestMapping
	public String listRacing(Model model) {
		Racing racing = new Racing();
		List<Horse> horses = horseService.initHorsesForRacing(racing
				.getNumberOfHorses());
		racing.setHorses(horses);
		model.addAttribute("racing", racing);
		model.addAttribute("listRacing", racingService.findAllRacings());
		model.addAttribute("horseList", horseService.listHorse());
		return "/racing";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addRacing(Model model,
			@Valid @ModelAttribute("racing") Racing racing, BindingResult result) {
		if (result.hasErrors()) {
			return listRacing(model);
		}

		racingService.addRacing(racing);
		return "redirect:/racing.html";
	}

	@RequestMapping("/delete/{id}")
	public String deleteRacing(@PathVariable("id") Integer id) {
		racingService.removeRacing(id);
		return "redirect:/racing.html";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
