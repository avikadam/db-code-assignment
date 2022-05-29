package com.db.tradestore.service;

public enum TradeExpiryFlag {
	YES("Y"), NO("N");

	private final String flag;

	private TradeExpiryFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}
}
