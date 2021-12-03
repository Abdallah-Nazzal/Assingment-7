package edu.najah.it.capp.exception;

public class TimeOutError extends ProtocolException {

	public TimeOutError(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[Timeout Error :: ] " + message;
		
	}

}
