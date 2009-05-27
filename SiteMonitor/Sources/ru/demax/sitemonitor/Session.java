package ru.demax.sitemonitor;

import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;

	public Handler handler = new Handler();
	
	public Session() {
	}
}
