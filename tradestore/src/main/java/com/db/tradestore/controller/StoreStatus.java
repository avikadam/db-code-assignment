package com.db.tradestore.controller;

public enum StoreStatus {
	OK("Trade presisted"), REJECT_INVALID_MATURITY("Invalid maturity date"), REJECT_INVALID_VERSION("Invalid version");

	private final String message;

	private StoreStatus(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
