package net.tarasyuk.horseracebets.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tarasyuk.horseracebets.data.FeedSource;
import net.tarasyuk.horseracebets.exception.RssException;
import net.tarasyuk.horseracebets.rssservice.Item;
import net.tarasyuk.horseracebets.rssservice.RssService;

@Service
public class FeedItemServiceImpl implements FeedItemService {

	@Autowired
	RssService rssService;

	public List<Item> getItems() throws RssException {

		List<Item> items = rssService
				.getItems(FeedSource.getUrl());

		Collections.sort(items, Collections.reverseOrder());
		return items;
	}

}
