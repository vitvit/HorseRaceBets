package net.tarasyuk.horseracebets.service;

import java.util.List;

import net.tarasyuk.horseracebets.exception.RssException;
import net.tarasyuk.horseracebets.rssservice.Item;

public interface FeedItemService {

	public List<Item> getItems() throws RssException;

}
