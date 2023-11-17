package com.solvd.hardwarestore1;/*
This method is going to have the information and method that a person should have
Its mandatory to add a person that it has all the data
 */

public abstract class Person {
    private String personName;//the person full name and surname
    private String personEmail;//the person email
    private String phoneNumber;//the person phone number

    public abstract void checkAge();

    //Constructor
    public Person(String personName,String personEmail, String phoneNumber){
        this.personName=personName;
        this.personEmail=personEmail;
        this.phoneNumber=phoneNumber;
    }

    //end constructor


    //Getters and setters

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //End getters and setters

    //Abstract method

}
