package com.db.tradestore.repository;

import java.util.List;
import java.util.Optional;

import com.db.tradestore.model.Trade;

/**
 * Trade store repository API
 * 
 * @author Avinash Kadam
 *
 */
public interface TradeStoreRepository {

	/**
	 * Save trade
	 * 
	 * @param trade
	 */
	void save(Trade trade);

	/**
	 * Find all trades
	 * 
	 * @return
	 */
	List<Trade> findAll();

	/**
	 * Fins trade by trade id
	 * 
	 * @param tradeId
	 * @return
	 */
	Optional<Trade> findTrade(String tradeId);

}