package ru.demax.sitemonitor.controllers;

import ru.demax.sitemonitor.Factory;
import ru.demax.sitemonitor.checking.WebsiteChecker;
import ru.demax.sitemonitor.model.Website;

import com.webobjects.appserver.WOComponent;

import er.directtoweb.delegates.ERDBranchDelegate;

public class WebsiteController extends ERDBranchDelegate {
	
	private Website website(WOComponent sender) {
		return (Website) object(sender);
	}

	public WOComponent edit(WOComponent sender) {
		return Factory.factory().editWebsite(sender.session(), website(sender));
	}

	public WOComponent delete(WOComponent sender) {
		return Factory.factory().deleteWebsite(sender.session(), website(sender));
	}
	
	public WOComponent check(WOComponent sender) {
		return new WebsiteChecker().check(sender.session(), website(sender));
	}
}
