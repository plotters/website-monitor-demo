package ru.demax.sitemonitor.checking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ru.demax.sitemonitor.WebsiteStatusPageFactory;
import ru.demax.sitemonitor.model.Website;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOSession;


public class WebsiteCheckerTest {
	
	private WebsiteStatusPageFactory factory = mock(WebsiteStatusPageFactory.class); 
	private UrlAvailabilityChecker urlChecker = mock(UrlAvailabilityChecker.class);
	private Website website = mock(Website.class);

	private WOComponent upMessage = mock(WOComponent.class);
	private WOComponent downMessage = mock(WOComponent.class);

	private WOSession session = null;
	private String url = null;

	private WebsiteChecker checker = new WebsiteChecker(factory, urlChecker);
	
	@Test
	public void returnsUpMessagePageIfSiteHasAvailableUrl() {
		when(website.url()).thenReturn(url);
		when(urlChecker.isUp(url)).thenReturn(true);
		when(factory.upMessage(session, website)).thenReturn(upMessage);
		
		WOComponent message = checker.check(session, website);
		
		assertThat(message, is(message));
	}
	
	@Test
	public void returnsDownMessagePageIfSiteHasUnavailableUrl() {
		when(website.url()).thenReturn(url);
		when(urlChecker.isUp(url)).thenReturn(false);
		when(factory.downMessage(session, website)).thenReturn(downMessage);
		
		WOComponent message = checker.check(session, website);
		
		assertThat(message, is(downMessage));
	}

}