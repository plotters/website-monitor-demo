package ru.demax.sitemonitor.checking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.HttpURLConnection;

import org.junit.Test;


public class HTTPStatusCheckerTest {

	private StatusFetcher statusFetcher = mock(StatusFetcher.class);

	private String url;

	@Test
	public void returnsTrueIfStatusCodeIsOK() {
		when(statusFetcher.fetch(url)).thenReturn(HttpURLConnection.HTTP_OK);
		
		boolean isUp = new HTTPStatusChecker(statusFetcher).isUp(url);
		
		assertThat(isUp, is(true));
	}

	@Test
	public void returnsTrueIfStatusCodeIsNotOK() {
		int errorStatus = HttpURLConnection.HTTP_BAD_REQUEST;
		
		when(statusFetcher.fetch(url)).thenReturn(errorStatus);
		
		boolean isUp = new HTTPStatusChecker(statusFetcher).isUp(url);
		
		assertThat(isUp, is(false));
	}
}
