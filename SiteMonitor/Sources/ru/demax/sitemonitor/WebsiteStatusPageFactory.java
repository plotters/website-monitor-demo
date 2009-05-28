package ru.demax.sitemonitor;

import ru.demax.sitemonitor.model.Website;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOSession;

public interface WebsiteStatusPageFactory {

	WOComponent upMessage(WOSession session, Website website);

	WOComponent downMessage(WOSession session, Website website);

}
