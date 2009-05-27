package ru.demax.simplelook.utils;


import er.extensions.foundation.ERXStringUtilities;

public class PropertyKeyToCssConverter {
	public String convertPropertyKeyToCssStyle(String propertyKey) {
    	String[] words =  propertyKey.split("\\.");
    	StringBuffer sb = new StringBuffer(words[0]);
    	for(int i = 1; i < words.length; i++) {
    		sb.append(ERXStringUtilities.capitalize(words[i]));
    	}
    	return sb.toString();
	}
}
