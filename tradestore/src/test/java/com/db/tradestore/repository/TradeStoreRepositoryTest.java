package com.db.tradestore.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.db.tradestore.model.Trade;

@TestMethodOrder(OrderAnnotation.class)
class TradeStoreRepositoryTest {

	private TradeStoreRepository repository = new TradeStoreRepositoryInMemory();

	private static final List<Trade> trades = new ArrayList<>(4);

	@BeforeAll
	public static void setup() {
		trades.add(new Trade("T1", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));
		trades.add(new Trade("T2", 2, "CP-2", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));
		trades.add(new Trade("T2", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.of(2015, 5, 20), "N"));
		trades.add(new Trade("T3", 3, "CP-3", "B2", LocalDate.of(2022, 5, 20), LocalDate.now(), "Y"));
	}

	@Test
	@Order(1)
	void testSave() {
		trades.forEach(t -> repository.save(t));
		Optional<Trade> trade = this.repository.findTrade("T1");
		assertTrue(trade.isPresent(), "T1 trade must be stored");
	}

	@Test
	@Order(2)
	void testFindAll() {
		List<Trade> trades = repository.findAll();
		assertTrue(trades.size() > 0, "There should be three trade records");
	}

	@Test
	@Order(3)
	void testFindTrade() {
		Optional<Trade> trade = this.repository.findTrade("T1");
		assertTrue(trade.isPresent(), "T1 trade must be found");
	}

}
