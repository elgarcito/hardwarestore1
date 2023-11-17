package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class GardenProduct  extends Product {
    private static final Logger LOGGER= LogManager.getLogger(GardenProduct.class);

    private boolean itsPoison;//Check if the product is poison or not

    //This is a public list
    private static final Set<GardenProduct> gardenProductSetList =new HashSet<GardenProduct>();


    private String gardenId;
    //constructor
    public GardenProduct(String productName, String productDescription,boolean itsPoison){
        super(productName,productDescription);
        this.itsPoison=itsPoison;
        this.gardenId=setGardenId();


    }
    //End constructor

    //getter and setter

    public boolean isItsPoison() {
        return itsPoison;
    }

    public void setItsPoison(boolean itsPoison) {
        this.itsPoison = itsPoison;
    }



    public String getGardenId() {
        return gardenId;
    }

    public String setGardenId() {
        int a= this.hashCode();
        if (this.hashCode()<0){
            a*=-1;
        }
        return this.gardenId = "GR"+a;
    }

    public static Set<GardenProduct> getGardenProductSetList() {
        return gardenProductSetList;
    }

    public static void setGardenProductSetList(GardenProduct gardenProduct) {
        GardenProduct.gardenProductSetList.add(gardenProduct);
    }

    //end getter and setter
    //Methods
    public static void seeGardenProductList(){
        for (GardenProduct gardenProduct:GardenProduct.getGardenProductSetList()) {
            System.out.println();
            LOGGER.info(gardenProduct.toString());
        }
    }
    //End methods

    //Method override
    @Override
    public String toString(){
        String poison;
        if (this.itsPoison){
            poison="poisonous";
        }else {
            poison="non poisonous";}

        return  "The resume name of the product is:\n"+this.getProductName()
                +"\nThe full description is:\n"+this.getProductDescription()
                +"\nIt is a "+poison+" product";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GardenProduct)) return false;
        GardenProduct that = (GardenProduct) o;
        return itsPoison == that.itsPoison && Objects.equals(gardenId, that.gardenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getProductName(), this.getProductDescription());
    }

    //end override methods

}
