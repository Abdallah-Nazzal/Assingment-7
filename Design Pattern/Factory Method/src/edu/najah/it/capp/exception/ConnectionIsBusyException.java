package edu.najah.it.capp.exception;

public class ConnectionIsBusyException extends ProtocolException {

	public ConnectionIsBusyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[Connection is busy Exception :: ] " + message;
		
	}

}
