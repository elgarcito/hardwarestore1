package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public enum CurrencyExchange {
    EURO (0.91),
    COLOMBIAN_PESO (3993.10),
    CHINESE_YUAN (7.09);
    private final double exchangeRate;
    private static final Logger LOGGER= LogManager.getLogger(CurrencyExchange.class);

    private final String webUsed="www.knowmoney.com";
    CurrencyExchange(double exchangeRate) {
        this.exchangeRate=exchangeRate;
    }

    static void showExchangeRate(){
        for (CurrencyExchange money: CurrencyExchange.values()) {
            LOGGER.info("The exchange rate for 1 USD to : "+ money+" is: " + money.exchangeRate);
        }
    }

    static void changeAmount(double moneyAmount){
        LOGGER.info(moneyAmount+"$ USD = Euro: "+ CurrencyExchange.EURO.exchangeRate*moneyAmount+"$");
        LOGGER.info(moneyAmount+"$ USD = Colombian peso: "+ CurrencyExchange.COLOMBIAN_PESO.exchangeRate*moneyAmount+"$");
        LOGGER.info(moneyAmount+"$ USD = Chinese Yuan: "+ CurrencyExchange.CHINESE_YUAN.exchangeRate*moneyAmount+"$");
    }



}
