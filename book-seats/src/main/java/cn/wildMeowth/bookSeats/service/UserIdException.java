package cn.wildMeowth.bookSeats.service;

public class UserIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserIdException() {
	}

	public UserIdException(String message) {
		super(message);
	}

	public UserIdException(Throwable cause) {
		super(cause);
	}

	public UserIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
