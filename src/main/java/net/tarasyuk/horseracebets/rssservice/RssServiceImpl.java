package net.tarasyuk.horseracebets.rssservice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import net.tarasyuk.horseracebets.exception.RssException;
import net.tarasyuk.horseracebets.rss.ObjectFactory;
import net.tarasyuk.horseracebets.rss.TRss;
import net.tarasyuk.horseracebets.rss.TRssChannel;
import net.tarasyuk.horseracebets.rss.TRssItem;

import org.springframework.stereotype.Service;

@Service
public class RssServiceImpl implements RssService {

	public List<Item> getItems(File file) throws RssException {
		return getItems(new StreamSource(file));
	}

	public List<Item> getItems(String url) throws RssException {
		return getItems(new StreamSource(url));
	}

	private List<Item> getItems(Source source) throws RssException {

		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source,
					TRss.class);
			TRss rss = jaxbElement.getValue();

			List<TRssChannel> channels = rss.getChannel();
			for (TRssChannel channel : channels) {
				List<TRssItem> items = channel.getItem();
				for (TRssItem rssItem : items) {
					Item item = new Item();
					item.setTitle(rssItem.getTitle());
					item.setDescription(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					Date pubDate = new SimpleDateFormat(
							"EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
							.parse(rssItem.getPubDate());
					item.setPublishedDate(pubDate);
					itemList.add(item);
				}
			}

		} catch (JAXBException e) {
			throw new RssException(e);

		} catch (java.text.ParseException e) {
			throw new RssException(e);
		}
		return itemList;
	}
}
