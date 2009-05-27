package ru.demax.simplelook.pages;


import com.webobjects.appserver.WOContext;

import er.directtoweb.pages.ERD2WMessagePage;

public class DMMessagePage extends ERD2WMessagePage {

	public DMMessagePage(WOContext context) {
        super(context);
    }
    
	// TODO: Needed, since we can't use ERDActionBar or ERDControllerButton - they generate
	// buttons and we need links. Should probably add link support to these components in ERD.
    public String branchLinkLabel() {
    	return (String)branch().valueForKey("branchButtonLabel");
    }
    
    @Override
    public String message() {
    	String message = super.message();
    	if (message != null) {
    		return message;
		}
    	
    	return "PageMessage." + d2wContext().dynamicPage();
    }
    
}