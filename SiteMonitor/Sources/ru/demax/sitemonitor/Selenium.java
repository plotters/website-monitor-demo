package ru.demax.sitemonitor;

import ru.demax.sitemonitor.checking.WebsiteChecker;
import ru.demax.sitemonitor.model.Website;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import er.selenium.SeleniumAction;

public class Selenium extends SeleniumAction {

	public Selenium(WORequest request) {
		super(request);
	}
	
	public WOActionResults cleanupAction() {
		new WebsiteBuilder().cleanup();
		
		return success();
	}
	
	public WOActionResults createExampleWebsiteAction() {
		new WebsiteBuilder().build();
		
		return success();
	}

	public WOActionResults listWithExampleWebsiteAction() {
		new WebsiteBuilder().build();
		
		return Factory.factory().listWebsites(session());
	}
	
	public WOActionResults checkSiteWithRedirectAction() {
		Website website = new WebsiteBuilder().withRedirectingUrl().build();
		
		return new WebsiteChecker().check(session(), website);
	}
}
