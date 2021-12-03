package edu.najah.it.capp.exception;

public class SystemIsBusy extends ProtocolException {

	public SystemIsBusy(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[System is busy :: ] " + message;
		
	}
}
