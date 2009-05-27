package ru.demax.simplelook.pages;


import ru.demax.simplelook.utils.PropertyKeyToCssConverter;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.directtoweb.NextPageDelegate;

import er.directtoweb.pages.ERD2WInspectPage;
import er.extensions.foundation.ERXValueUtilities;
import er.extensions.localization.ERXLocalizer;

public class DMEditPage extends ERD2WInspectPage {

    protected WOComponent _cancelPage;
    protected NextPageDelegate _cancelDelegate;

    public DMEditPage(WOContext context) {
        super(context);
    }
    
	public NextPageDelegate cancelDelegate() {
		return _cancelDelegate;
	}

	public void setCancelDelegate(NextPageDelegate cancelDelegate) {
		_cancelDelegate = cancelDelegate;
	}

	public WOComponent cancelPage() {
		return _cancelPage;
	}
	
	public void setCancelPage(WOComponent cancelPage) {
		_cancelPage = cancelPage;
	}

	public boolean hasCancelPage() {
    	return cancelPage() != null || cancelDelegate() != null;
    }

    public WOComponent cancelAction() {
		return cancelDelegate() != null ? cancelDelegate().nextPage(context().page()) : cancelPage();
	}
    
    public String propertyDivCssClass() {
    	StringBuilder sb = new StringBuilder();
    	if (ERXValueUtilities.booleanValue(d2wContext().valueForKey("hidePropertyName"))) {
			sb.append("hidePropertyName");
		}
    	
    	if (ERXValueUtilities.booleanValue(d2wContext().valueForKey("isEditString"))) {
    		if (sb.length() > 0) {
				sb.append(" ");
			}
    		sb.append("isEditString");
    	}
    	
    	return sb.length() != 0 ? sb.toString() : null;
    }
    
    public String propertyKeyID() {
    	return new PropertyKeyToCssConverter().convertPropertyKeyToCssStyle(propertyKey());
    }

	public String message() {
		return ERXLocalizer.currentLocalizer().localizedStringForKey("PageMessage." + d2wContext().dynamicPage());
	}

}