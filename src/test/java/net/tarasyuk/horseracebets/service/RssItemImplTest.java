package net.tarasyuk.horseracebets.service;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import net.tarasyuk.horseracebets.exception.RssException;
import net.tarasyuk.horseracebets.rssservice.Item;
import net.tarasyuk.horseracebets.rssservice.RssService;
import net.tarasyuk.horseracebets.rssservice.RssServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class RssItemImplTest {

	private RssService rssService;

	@Before
	public void setUp() throws Exception {

		rssService = new RssServiceImpl();

	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems(new File(
				"test-rss/horse-racing.xml"));
		assertEquals(20, items.size());
		Item firstItem = items.get(0);
		assertEquals("Big Brown a big bust at Belmont, denied Triple Crown (monsters and critics)", firstItem.getTitle());
		assertEquals("08 06 2008 07:36:00", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
	}

}
