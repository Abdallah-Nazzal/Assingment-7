package edu.najah.it.capp.asd.impl;

import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.ConnectionIsBusyException;
import edu.najah.it.capp.exception.ConnectionIsReleasedException;
import edu.najah.it.capp.exception.NoConnectionAvaliable;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.SystemIsBusy;
import edu.najah.it.capp.exception.TimeOutError;
import edu.najah.it.capp.exception.UnknownErrorException;

public class Ssh implements Protocol {

	private static Protocol instance;

	private Ssh() {
		System.out.println("Creating a new SSH insatnce");
	}

	protected static Protocol getInsatnce() {
		if (instance == null) {
			instance = new Ssh();
		}
		return instance;
	}

	@Override
	public boolean release() throws ProtocolException {

		if (instance == null) {
			throw new ConnectionIsReleasedException("Connection is Already Released");
		} else if (instance != null) {
			throw new UnknownErrorException("Unknown Error: Can't release connection!");
		} else {
			throw new ConnectionIsBusyException("Connection is Busy: Can't release connection!");
		}

	}

	@Override
	public void send(String message) throws ProtocolException {
		if (message == null) {
			throw new NoConnectionAvaliable("Sending message from connection that is does not exist!");
		}
		if (message != null) {
			throw new TimeOutError("Failed to send the data because of a timeout error.");
		}
		if (message != null) {
			throw new SystemIsBusy("System is busy now!");
		}
		System.out.println("Sending message from FTP :: " + message);
	}

}
