package com.solvd.hardwarestore1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

public enum BankAccounts {
    OWNER_ACCOUNT ("VU.LU.SU",32434354),
    BUSINESS_ACCOUNT ("PU.CU.TU",384926248),
    ACCOUNTANT_ACCOUNT ("RU.SU.MU",384148461);
    private final String alias;
    private final long cbu;
    private final String bankName="sontander";
    private static final Logger LOGGER= LogManager.getLogger(BankAccounts.class);
    BankAccounts(String alias, long cbu){
        this.alias=alias;
        this.cbu=cbu;
    }
    static void showBankAccounts(){

        for (BankAccounts account: BankAccounts.values()) {
            LOGGER.info("The bank account of "+ account +" has for alias: "
            +account.alias+" and for CBU: "+account.cbu);
        }
    }


}
