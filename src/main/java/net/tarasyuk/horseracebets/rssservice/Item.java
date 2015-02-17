package net.tarasyuk.horseracebets.rssservice;

import java.util.Date;

public class Item implements Comparable<Item> {

	private String title;

	private String description;

	private Date publishedDate;

	private String link;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int compareTo(Item o) {
		return getPublishedDate().compareTo(o.getPublishedDate());
	}

}
