package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public enum CurrencyExchange {
    EURO (0.91),
    COLOMBIAN_PESO (3993.10),
    CHINESE_YUAN (7.09);
    private final double EXCHANGE_RATE;
    private static final Logger LOGGER= LogManager.getLogger(CurrencyExchange.class);

     CurrencyExchange(double exchangeRate) {
        this.EXCHANGE_RATE =exchangeRate;
    }

     static void showExchangeRate(){
        for (CurrencyExchange money: CurrencyExchange.values()) {
            LOGGER.info("The exchange rate for 1 USD to : "+ money+" is: " + money.EXCHANGE_RATE);
        }
    }

     static void changeAmount(double moneyAmount){
        LOGGER.info(moneyAmount+"$ USD = Euro: "+ CurrencyExchange.EURO.EXCHANGE_RATE *moneyAmount+"$");
        LOGGER.info(moneyAmount+"$ USD = Colombian peso: "+ CurrencyExchange.COLOMBIAN_PESO.EXCHANGE_RATE *moneyAmount+"$");
        LOGGER.info(moneyAmount+"$ USD = Chinese Yuan: "+ CurrencyExchange.CHINESE_YUAN.EXCHANGE_RATE *moneyAmount+"$");
    }



}
