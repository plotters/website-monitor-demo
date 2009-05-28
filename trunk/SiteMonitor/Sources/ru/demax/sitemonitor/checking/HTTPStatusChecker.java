package ru.demax.sitemonitor.checking;

import java.net.HttpURLConnection;

public class HTTPStatusChecker implements UrlAvailabilityChecker {

	private final StatusFetcher statusFetcher;

	public HTTPStatusChecker(StatusFetcher statusFetcher) {
		this.statusFetcher = statusFetcher;
	}

	public HTTPStatusChecker() {
		this.statusFetcher = new HTTPStatusFetcher();
	}

	public boolean isUp(String url) {
		int status = statusFetcher.fetch(url);
		
		return status == HttpURLConnection.HTTP_OK ? true : false;
	}

}
