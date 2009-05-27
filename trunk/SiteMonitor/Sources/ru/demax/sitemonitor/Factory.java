package ru.demax.sitemonitor;

import ru.demax.sitemonitor.model.Website;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOSession;
import com.webobjects.directtoweb.D2W;
import com.webobjects.directtoweb.ListPageInterface;
import com.webobjects.eoaccess.EODatabaseDataSource;
import com.webobjects.eocontrol.EODataSource;

import er.directtoweb.ERD2WFactory;

public class Factory extends ERD2WFactory {

	public static Factory factory() {
		return (Factory) D2W.factory();
	}

	public WOComponent listWebsites(WOSession session) {
		ListPageInterface lpi = listPageForEntityNamed(Website.ENTITY_NAME, session);
		EODataSource ds = new EODatabaseDataSource(session.defaultEditingContext(), Website.ENTITY_NAME);
		lpi.setDataSource(ds);
		
		return (WOComponent) lpi;
	}
}
