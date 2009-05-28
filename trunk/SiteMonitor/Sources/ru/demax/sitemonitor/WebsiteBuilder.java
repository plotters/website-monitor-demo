package ru.demax.sitemonitor;

import ru.demax.sitemonitor.model.Website;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;

public class WebsiteBuilder {

	private String name = "Apple";
	private String url = "http://www.apple.com";

	public void cleanup() {
		EOEditingContext ec = ERXEC.newEditingContext();
		Website website = Website.fetchWebsite(ec, Website.NAME.eq(name));
		if (website != null) {
			ec.deleteObject(website);
			ec.saveChanges();
		}
	}

	public Website build() {
		EOEditingContext ec = ERXEC.newEditingContext();
		Website website = Website.createWebsite(ec, name, url);
		ec.saveChanges();
		
		return website;
	}

	public WebsiteBuilder withRedirectingUrl() {
		url = "http://apple.com";
		
		return this;
	}

}
