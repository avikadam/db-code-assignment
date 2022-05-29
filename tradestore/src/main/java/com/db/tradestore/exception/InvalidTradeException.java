package com.db.tradestore.exception;

public class InvalidTradeException extends RuntimeException {

	private static final long serialVersionUID = 7921217894568166965L;

	public InvalidTradeException(String message) {
		super(message);
	}
}
