package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HouseholdItem extends Product {
    private static final Logger LOGGER= LogManager.getLogger(HouseholdItem.class);
    private boolean itIsASet;//It check it the product it is a set or not for example a set of kitchen knifes
    private int unitsPerSet; //If it is a set it tells how many items it has
    //Product list
    private static final List<HouseholdItem> householdItemArrayList= new ArrayList<HouseholdItem>();

    //Constructor
    public HouseholdItem(String productName,String productDescription){
        super(productName,productDescription);
    }
    //end constructor

    //Getters and setters


    public boolean isItIsASet() {
        return itIsASet;
    }

    public void setItIsASet(boolean itIsASet) {
        this.itIsASet = itIsASet;
    }

    public int getUnitsPerSet() {
        return unitsPerSet;
    }

    public void setUnitsPerSet(int unitsPerSet) {
        this.unitsPerSet = unitsPerSet;
    }
    //Setter to the arraylist
    public static void setHouseholdItemArrayList(HouseholdItem householdProduct){
        HouseholdItem.householdItemArrayList.add(householdProduct);

    }
    //getter to the list of householdItem
    public static List<HouseholdItem> getHouseholdItemArrayList() {
        return householdItemArrayList;
    }

//End getters and setters

    //Methods
    public static void seeHouseholdItems(){
        for (HouseholdItem householdProduct:HouseholdItem.getHouseholdItemArrayList()) {
            System.out.println();
            LOGGER.info(householdProduct.toString());
        }
    }
    //End methods
    //Override methods
    @Override
    public String toString(){
        return  "The resume name of the product is:\n"+this.getProductName()
                +"\nThe full description is:\n"+this.getProductDescription();
    }
    //end override methods




}
