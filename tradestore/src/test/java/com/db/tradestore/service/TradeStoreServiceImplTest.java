package com.db.tradestore.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.db.tradestore.TradeStoreApplication;
import com.db.tradestore.controller.StoreStatus;
import com.db.tradestore.model.Trade;

@SpringJUnitConfig(TradeStoreApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(args = "--spring.application.run.mode=DEV")
@TestMethodOrder(OrderAnnotation.class)
class TradeStoreServiceImplTest {

	@SpyBean
	private TradeStoreService tradeStoreService;

	@Test
	@Order(1)
	void testIsValid() {
		StoreStatus status = this.tradeStoreService
				.isValid(new Trade("T7", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));
		assertSame(StoreStatus.OK, status);
	}

	@Test
	@Order(2)
	void testPersist() {
		this.tradeStoreService
				.persist(new Trade("T6", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));

		assertTrue(this.tradeStoreService.findTrade("T6").isPresent());
	}

	@Test
	@Order(3)
	void testFindAll() {
		assertTrue(this.tradeStoreService.findAll().size() > 0);
	}

	@Test
	@Order(4)
	void testExpireTrade() {
		try {
			this.tradeStoreService.expireTrade();
		} catch (Exception e) {
			fail("Failed to excute expire task");
		}
	}

}
