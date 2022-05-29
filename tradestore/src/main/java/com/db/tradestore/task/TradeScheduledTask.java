package com.db.tradestore.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.db.tradestore.service.TradeStoreService;

public class TradeScheduledTask {

	private static final Logger logger = LoggerFactory.getLogger(TradeScheduledTask.class);

	@Autowired
	private TradeStoreService tradeService;

	@Scheduled(cron = "0/30 * * * * ?")
	public void expireTask() {
		logger.info("Task triggred at {}", new Date());
		this.tradeService.expireTrade();
	}
}
