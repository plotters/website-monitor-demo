package ru.demax.sitemonitor;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.directtoweb.D2W;
import com.webobjects.directtoweb.D2WPage;
import com.webobjects.foundation.NSKeyValueCoding;

import er.extensions.foundation.ERXStringUtilities;

public class Handler implements NSKeyValueCoding {

	public void takeValueForKey(Object value, String key) {
		throw new UnsupportedOperationException("Can't takeValueForKey");
	}

	public Object valueForKey(String key) {
		WOActionResults result = (WOActionResults) NSKeyValueCoding.Utility.valueForKey(D2W.factory(), key);
		if (result instanceof D2WPage) {
			D2WPage page = (D2WPage) result;
			String state = ERXStringUtilities.capitalize(key);
			page.d2wContext().takeValueForKey(state, "navigationState");
		}
		
		return result;
	}

	
}
