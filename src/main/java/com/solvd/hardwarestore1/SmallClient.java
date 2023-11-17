package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class SmallClient {
    private static final Logger LOGGER= LogManager.getLogger(SmallClient.class);
    private Date dateOfBuy;//when the small client buy
    private String payMethod;//How it pay

    //Constructor
    public SmallClient(Date date, String payMethod){
        this.dateOfBuy=date;
        this.payMethod=payMethod;
    }
    //End constructor
    //getter and setters

    public Date getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(Date dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    //end getter and setters



}
