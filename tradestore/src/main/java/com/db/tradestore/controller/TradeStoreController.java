package com.db.tradestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.tradestore.exception.InvalidTradeException;
import com.db.tradestore.model.Trade;
import com.db.tradestore.service.TradeStoreService;

@Component
public class TradeStoreController {

	@Autowired
	private TradeStoreService tradeService;

	public StoreStatus storeTrade(Trade trade) {
		StoreStatus status = this.tradeService.isValid(trade);

		if (StoreStatus.OK.equals(status)) {
			tradeService.persist(trade);
		} else {
			throw new InvalidTradeException(String.format("Validation error : %s for trade with id %s",
					status.getMessage(), trade.getTradeId()));
		}
		return status;
	}

	public List<Trade> findAllTrades() {
		return this.tradeService.findAll();
	}
}
