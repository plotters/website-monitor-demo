package ru.demax.simplelook.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXSortOrder;

public class DMSortOrder extends ERXSortOrder {
    
	public DMSortOrder(WOContext context) {
        super(context);
    }
    
	public String cssClass() {
		return currentState() == SortedAscending ? "sortUp" : "sortDown";
	}

}