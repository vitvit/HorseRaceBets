package net.tarasyuk.horseracebets.rssservice;

import java.io.File;
import java.util.List;

import javax.xml.transform.Source;

import net.tarasyuk.horseracebets.exception.RssException;

public interface RssService {
	
	public List<Item> getItems(File file) throws RssException;
	
	public List<Item> getItems(String url) throws RssException;

}
