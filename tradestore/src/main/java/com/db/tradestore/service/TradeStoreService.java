package com.db.tradestore.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.db.tradestore.controller.StoreStatus;
import com.db.tradestore.model.Trade;

/**
 * Service interface between controller and repository to perform business
 * processing
 * 
 * @author Avinash Kadam
 *
 */
public interface TradeStoreService {

	/**
	 * Validate trade before storing it
	 * 
	 * @param trade - trade to validate
	 * @return
	 */
	public StoreStatus isValid(Trade trade);

	/**
	 * Save trade to persistent storage
	 * 
	 * @param trade - trade to save
	 */
	public void persist(Trade trade);

	/**
	 * Get all trades
	 * 
	 * @return
	 */
	public List<Trade> findAll();

	/**
	 * Find trade by id
	 * 
	 * @return
	 */
	public Optional<Trade> findTrade(String tradeId);

	/**
	 * Mark trade expired
	 */
	public void expireTrade();

	/**
	 * During transmission if the lower version is being received by the store it
	 * will reject the trade and throw an exception.
	 * 
	 * @param trade    - new trade record
	 * @param oldTrade - existing trade record
	 * @return
	 */
	default boolean hasValidVersion(Trade trade, Trade oldTrade) {
		return trade.getVersion() >= oldTrade.getVersion();
	}

	/**
	 * Store should not allow the trade which has less maturity date then today date
	 * 
	 * @param trade
	 * @return
	 */
	default boolean hasValidMaturityDate(Trade trade) {
		return trade.getMaturityDate().isAfter(LocalDate.now());
	}
}
