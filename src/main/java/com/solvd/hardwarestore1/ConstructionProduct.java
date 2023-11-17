package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstructionProduct extends RawMaterial {

    private static final Logger LOGGER= LogManager.getLogger(ConstructionProduct.class);
    private double fraction;//How you divide it, for example price per 1 kg, 10 kg, etc
    private boolean needLicense;
    private int licenceNumberLength;



    //Constructor
    public ConstructionProduct(String rawMaterialName, String rawMaterialDescription, String unitType) {
        super(rawMaterialName, rawMaterialDescription, unitType);
    }
    //End constructor

    //Getter and setter

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    //end getter and setter

    //methods

    @Override
    public boolean checkLicence(boolean needLicense,String licenceId,int licenceNumberLength){
        if (needLicense){
            if (licenceNumberLength ==licenceId.length()){
                LOGGER.info("License is OK");
                return true;
            }else{
                LOGGER.info("License is not OK");
                return false;
            }
        }
        LOGGER.info("no licence required");
        return true;
    }

}
