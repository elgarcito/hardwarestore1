package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PayingRates {

    //Doing private the constructor the final class cant be initialized
    private PayingRates(){}
    private static final Logger LOGGER= LogManager.getLogger(PayingRates.class);
    //How much you pay per hour to a category of employee
    public static int productCounter;
    //initialization method using static block

    private static final double SELLER_RATE=10.0;
    private static final double DEPOSIT_RATE=8;
    private static final double OWNER_RATE=15;


    final static void showRates(){
        String message = "The rates per hour according to speciality are: \n" +
                "Seller: "+ getSELLER_RATE()+" USD/h"+
                "\nDeposit employee: "+getDEPOSIT_RATE()+" USD/h"+
                "\nOwner: "+getOWNER_RATE()+" USD/h";
        LOGGER.info(message);
    }

    public static double getSELLER_RATE() {
        return SELLER_RATE;
    }

    public static double getDEPOSIT_RATE() {
        return DEPOSIT_RATE;
    }

    public static double getOWNER_RATE() {
        return OWNER_RATE;
    }
}
