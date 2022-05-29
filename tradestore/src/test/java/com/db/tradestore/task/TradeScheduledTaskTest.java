package com.db.tradestore.task;

import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.ONE_MINUTE;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.db.tradestore.TradeStoreApplication;

@SpringJUnitConfig(TradeStoreApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(args = "--spring.application.run.mode=DEV")
class TradeScheduledTaskTest {

	@SpyBean
	private TradeScheduledTask tradeScheduledTask;

	@Test
	void testScehduledTask() {
		await().atMost(ONE_MINUTE).untilAsserted(() -> verify(tradeScheduledTask, atLeast(2)).expireTask());
	}

}
