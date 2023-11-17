package com.solvd.hardwarestore1;

//We only save the data of the big clients for small costumers we have the SmallClient class
public class BigClient extends Person {
    String regularBuy;//The type of product that the big client buy
    public BigClient(String personName, String personEmail, String phoneNumber) {
        super(personName, personEmail, phoneNumber);
    }
}
