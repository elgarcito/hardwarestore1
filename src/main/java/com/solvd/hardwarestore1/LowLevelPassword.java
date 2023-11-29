
package com.solvd.hardwarestore1;

        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
public enum LowLevelPassword {
    CABLE_PASSWORD ("hwd1@gmail.com=Cable1234"),
    STEEL_SUPPLIER_PASSWORD ("hwd1@gmail.com=steel1234"),
    WATER_PUMP_PASSWORD ("hwd1@gmail.com=water1234");
    private final String accountPassword;

    private final String accessLevel="All users";
    private static final Logger LOGGER= LogManager.getLogger(CurrencyExchange.class);

    LowLevelPassword(String accountPassword) {
        this.accountPassword=accountPassword;
    }

    static void showPasswords(){
        for (LowLevelPassword password: LowLevelPassword.values()) {
            LOGGER.info("The logger info and password for: "+ password+" is: " + password.accountPassword);
        }
    }

}

