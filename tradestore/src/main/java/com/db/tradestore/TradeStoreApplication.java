package com.db.tradestore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.db.tradestore.controller.StoreStatus;
import com.db.tradestore.controller.TradeStoreController;
import com.db.tradestore.model.Trade;

@SpringBootApplication
@EnableScheduling
public class TradeStoreApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TradeStoreApplication.class);

	@Autowired
	private Environment env;

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TradeStoreApplication.class);
		springApplication.run(args);
	}

	@Override
	public void run(String... strings) {
		if ("DEV".equalsIgnoreCase(env.getProperty("spring.application.run.mode"))) {
			this.bootstrapTrades();
		}
	}

	private void bootstrapTrades() {
		TradeStoreController tradeStoreController = (TradeStoreController) appContext.getBean("tradeStoreController");

		List<Trade> trades = new ArrayList<>(4);

		trades.add(new Trade("T1", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));
		trades.add(new Trade("T2", 2, "CP-2", "B1", LocalDate.of(2022, 5, 20), LocalDate.now(), "N"));
		trades.add(new Trade("T2", 1, "CP-1", "B1", LocalDate.of(2022, 5, 20), LocalDate.of(2015, 5, 20), "N"));
		trades.add(new Trade("T3", 3, "CP-3", "B2", LocalDate.of(2022, 5, 20), LocalDate.now(), "Y"));

		for (Trade trade : trades) {
			StoreStatus status = null;
			try {
				status = tradeStoreController.storeTrade(trade);
			} catch (Exception e) {
				logger.error(String.format("%s : %s", e.getMessage(), trade.getTradeId()));
			}

			if (null != status && logger.isInfoEnabled()) {
				logger.info(String.format("%s : %s", status.getMessage(), trade.getTradeId()));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info(String.format("Total trades : %s", tradeStoreController.findAllTrades().size()));
		}
	}

}
