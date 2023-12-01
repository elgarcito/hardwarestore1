package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum EmergencyPhoneNumbers {
    EMERGENCY ("+5422992499"),
    POLICE ("+45842358665"),
    FIREFIGHTER ("+21912384");
    private final String PHONE_NUMBER;
    private static final Logger LOGGER= LogManager.getLogger(EmergencyPhoneNumbers.class);

    EmergencyPhoneNumbers(String phoneNumber) {
        this.PHONE_NUMBER =phoneNumber;
    }

     static void showNumbers(){
        for (EmergencyPhoneNumbers phoneNumber: EmergencyPhoneNumbers.values()) {
            LOGGER.info("The "+ phoneNumber+" phone number is: " + phoneNumber.PHONE_NUMBER);
        }
    }



}
