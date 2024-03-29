package ru.demax.simplelook.pages;


import ru.demax.simplelook.utils.PropertyKeyToCssConverter;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WODisplayGroup;
import com.webobjects.foundation.NSArray;

// Generated by the WOLips Templateengine Plug-in at Dec 28, 2007 7:16:15 PM
public class DMListPage extends er.directtoweb.pages.ERD2WListPage {
	public int rowIndex;

	public DMListPage(WOContext context) {
		super(context);
	}
	
	@Override
	// df: Default implementation uses empty array in case of sortOrdering == null
	// which leads to resetting of fs's sortOrderings in setupPhase upon batch
	// navigation (dg's sortOrderings are never null due to this and sortOrderings 
	// is set to dg.sortOrderings() early in setupPhase).
	//
	// Another related fix is "defaultSortOrdering = null" rule in DMCore's d2wmodel.
	// Default value in ERD2WDirectToWeb is empty array which leads to same problem 
	// with resetting of fs's sortOrderings.
	//
	// Both problems look like bugs to me but I'm not 100% confident in this to commit 
	// the fix to ERD2WListPage.
	protected void setSortOrderingsOnDisplayGroup(NSArray sortOrderings, WODisplayGroup dg) {
		if (sortOrderings == null) {
			return;
		}
		
		super.setSortOrderingsOnDisplayGroup(sortOrderings, dg);
	}

	public String rowClass() {
		return rowIndex % 2 == 0 ? "even" : "";
	}

	public String propertyCellClass() {
		StringBuffer result = new StringBuffer(new PropertyKeyToCssConverter().convertPropertyKeyToCssStyle(propertyKey()));
		if (isFirst()) {
			result.append(" first");
		}
		if (propertyKey().equals(displayPropertyKeys().lastObject())) {
			result.append(" last");
		}
		return result.toString();
	}

	public boolean isFirst() {
		return propertyKey().equals(displayPropertyKeys().objectAtIndex(0));
	}

}