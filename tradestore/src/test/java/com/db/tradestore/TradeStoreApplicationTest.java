package com.db.tradestore;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.db.tradestore.controller.StoreStatus;
import com.db.tradestore.controller.TradeStoreController;
import com.db.tradestore.model.Trade;

@SpringBootTest
class TradeStoreApplicationTest {

	@SpyBean
	private TradeStoreController controller;

	private static final List<Trade> trades = new ArrayList<>(4);

	@BeforeAll
	public static void setup() {
		trades.add(new Trade("T1", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));
		trades.add(new Trade("T2", 2, "CP-2", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));
		trades.add(new Trade("T2", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.of(2015, 5, 20), "N"));
		trades.add(new Trade("T3", 3, "CP-3", "B2", LocalDate.of(2022, 5, 20), LocalDate.now(), "Y"));
	}

	@Test
	void testTradeStoreTradeSignleVersion() {
		StoreStatus status = this.controller
				.storeTrade(new Trade("T1", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));

		assertSame(StoreStatus.OK, status);

		status = this.controller
				.storeTrade(new Trade("T1", 2, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));

		assertSame(StoreStatus.OK, status);
	}

}
