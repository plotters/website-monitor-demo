package ru.demax.sitemonitor;

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

}
