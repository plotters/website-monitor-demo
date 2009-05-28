package ru.demax.sitemonitor.checking;

import ru.demax.sitemonitor.Factory;
import ru.demax.sitemonitor.WebsiteStatusPageFactory;
import ru.demax.sitemonitor.model.Website;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOSession;

public class WebsiteChecker {

	private final UrlAvailabilityChecker urlChecker;
	private final WebsiteStatusPageFactory factory;

	public WebsiteChecker(WebsiteStatusPageFactory factory, UrlAvailabilityChecker urlChecker) {
		this.factory = factory;
		this.urlChecker = urlChecker;
	}

	public WebsiteChecker() {
		this(Factory.factory(), new HTTPStatusChecker());
	}

	public WOComponent check(WOSession session, Website website) {
		return urlChecker.isUp(website.url()) ? factory.upMessage(session, website) : null;
	}

}
