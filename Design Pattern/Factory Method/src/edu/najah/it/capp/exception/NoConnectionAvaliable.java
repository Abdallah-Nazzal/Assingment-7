package edu.najah.it.capp.exception;

public class NoConnectionAvaliable extends ProtocolException {

	public NoConnectionAvaliable(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[No Connection Avaliable :: ] " + message;
		
	}

}
