// $LastChangedRevision: 5773 $ DO NOT EDIT.  Make changes to Website.java instead.
package ru.demax.sitemonitor.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _Website extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Website";

	// Attributes
	public static final String NAME_KEY = "name";
	public static final String URL_KEY = "url";

	// Relationships

  private static Logger LOG = Logger.getLogger(_Website.class);

  public Website localInstanceIn(EOEditingContext editingContext) {
    Website localInstance = (Website)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_Website.LOG.isDebugEnabled()) {
    	_Website.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public String url() {
    return (String) storedValueForKey("url");
  }

  public void setUrl(String value) {
    if (_Website.LOG.isDebugEnabled()) {
    	_Website.LOG.debug( "updating url from " + url() + " to " + value);
    }
    takeStoredValueForKey(value, "url");
  }


  public static Website createWebsite(EOEditingContext editingContext, String name
, String url
) {
    Website eo = (Website) EOUtilities.createAndInsertInstance(editingContext, _Website.ENTITY_NAME);    
		eo.setName(name);
		eo.setUrl(url);
    return eo;
  }

  public static NSArray<Website> fetchAllWebsites(EOEditingContext editingContext) {
    return _Website.fetchAllWebsites(editingContext, null);
  }

  public static NSArray<Website> fetchAllWebsites(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Website.fetchWebsites(editingContext, null, sortOrderings);
  }

  public static NSArray<Website> fetchWebsites(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Website.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Website> eoObjects = (NSArray<Website>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Website fetchWebsite(EOEditingContext editingContext, String keyName, Object value) {
    return _Website.fetchWebsite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Website fetchWebsite(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Website> eoObjects = _Website.fetchWebsites(editingContext, qualifier, null);
    Website eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Website)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Website that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Website fetchRequiredWebsite(EOEditingContext editingContext, String keyName, Object value) {
    return _Website.fetchRequiredWebsite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Website fetchRequiredWebsite(EOEditingContext editingContext, EOQualifier qualifier) {
    Website eoObject = _Website.fetchWebsite(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Website that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Website localInstanceIn(EOEditingContext editingContext, Website eo) {
    Website localInstance = (eo == null) ? null : (Website)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
