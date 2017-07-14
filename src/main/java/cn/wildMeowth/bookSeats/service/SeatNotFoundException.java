package cn.wildMeowth.bookSeats.service;

public class SeatNotFoundException extends RuntimeException {


	public SeatNotFoundException() {
	}

	public SeatNotFoundException(String message) {
		super(message);
	}

	public SeatNotFoundException(Throwable cause) {
		super(cause);
	}

	public SeatNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeatNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
