package com.db.tradestore.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.db.tradestore.model.Trade;

/**
 * In memory implementation of trade store
 * 
 * @author Avinash Kadam
 *
 */
@Component
public class TradeStoreRepositoryInMemory implements TradeStoreRepository {

	private static final Map<String, Trade> tradeMap = new ConcurrentHashMap<>();

	@Override
	public void save(Trade trade) {
		trade.setCreatedDate(LocalDate.now());
		tradeMap.put(trade.getTradeId(), trade);
	}

	@Override
	public List<Trade> findAll() {
		return tradeMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Optional<Trade> findTrade(String tradeId) {
		return Optional.ofNullable(tradeMap.get(tradeId));
	}
}
