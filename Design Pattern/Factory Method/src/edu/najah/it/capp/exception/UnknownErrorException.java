package edu.najah.it.capp.exception;

public class UnknownErrorException extends ProtocolException {

	public UnknownErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "[Unknown erorr Exception :: ] " + message;
		
	}

}
