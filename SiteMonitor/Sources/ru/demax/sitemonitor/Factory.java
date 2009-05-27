package ru.demax.sitemonitor;

import ru.demax.sitemonitor.model.Website;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOSession;
import com.webobjects.directtoweb.D2W;
import com.webobjects.directtoweb.EditPageInterface;
import com.webobjects.directtoweb.ListPageInterface;
import com.webobjects.eoaccess.EODatabaseDataSource;
import com.webobjects.eocontrol.EODataSource;
import com.webobjects.eocontrol.EOEditingContext;

import er.directtoweb.ERD2WFactory;
import er.extensions.appserver.ERXSession;
import er.extensions.eof.ERXEC;

public class Factory extends ERD2WFactory {

	public static Factory factory() {
		return (Factory) D2W.factory();
	}

	private WOSession session() {
		return ERXSession.session();
	}

	public WOComponent listWebsites(WOSession session) {
		ListPageInterface lpi = listPageForEntityNamed(Website.ENTITY_NAME, session);
		EODataSource ds = new EODatabaseDataSource(session.defaultEditingContext(), Website.ENTITY_NAME);
		lpi.setDataSource(ds);
		
		return (WOComponent) lpi;
	}

	public WOComponent editWebsite(WOSession session, Website website) {
		EditPageInterface epi = editPageForEntityNamed(Website.ENTITY_NAME, session);

		EOEditingContext ec = ERXEC.newEditingContext();
		Website localWebsite = website.localInstanceIn(ec);
		epi.setObject(localWebsite);
		
		return (WOComponent) epi;
	}

	public WOComponent deleteWebsite(WOSession session, Website website) {
		EOEditingContext ec = ERXEC.newEditingContext();
		Website localWebsite = website.localInstanceIn(ec);
		ec.deleteObject(localWebsite);
		ec.saveChanges();
		
		return session.context().page();
	}

	public WOComponent createWebsite() {
		EditPageInterface epi = editPageForNewObjectWithEntityNamed(Website.ENTITY_NAME, session());
		epi.setNextPage(session().context().page());
		
		return (WOComponent) epi;
	}

	public WOComponent checkWebsite(WOSession session, Website website) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
