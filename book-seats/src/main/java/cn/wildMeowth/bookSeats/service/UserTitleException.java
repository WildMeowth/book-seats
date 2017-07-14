package cn.wildMeowth.bookSeats.service;

public class UserTitleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserTitleException() {
	}

	public UserTitleException(String message) {
		super(message);
	}

	public UserTitleException(Throwable cause) {
		super(cause);
	}

	public UserTitleException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
