package net.tarasyuk.horseracebets.controller;

import net.tarasyuk.horseracebets.exception.RssException;
import net.tarasyuk.horseracebets.service.FeedItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedController {

	@Autowired
	FeedItemService feedItemService;

	@RequestMapping("/feed")
	public String feed(Model model) throws RssException {
		model.addAttribute("items", feedItemService.getItems());
		return "feed";
	}

}
