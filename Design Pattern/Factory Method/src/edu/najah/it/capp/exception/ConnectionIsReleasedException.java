package edu.najah.it.capp.exception;

public class ConnectionIsReleasedException extends ProtocolException {

	public ConnectionIsReleasedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[Connection is already released Exception :: ] " + message;
		
	}

}
