package com.solvd.hardwarestore1;

public class Supplier extends Person {

    private String productSupplied;//What kind of product supplies

    //Constructor
    public Supplier(String personName, String personEmail, String phoneNumber,String productSupplied) {
        super(personName, personEmail, phoneNumber);
        this.productSupplied=productSupplied;
    }

    //end constructor

    //Getter and setter

    public String getProductSupplied() {
        return productSupplied;
    }

    public void setProductSupplied(String productSupplied) {
        this.productSupplied = productSupplied;
    }

    //end getter and setter

}
