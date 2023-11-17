package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElectricProduct extends Product implements Costable, Available, Sellable, StockChangeable {
    //The static product counter expand itself any time a product is created but initialice in 0 every time the
    //program initiate
    static int productCounter;
    static {
        productCounter=0;
        try (FileReader fileReader=new FileReader("log4j2.xml")){
            System.setProperty("log4j.configurationFile", "log4j2.xml");
        }catch (IOException e){
            System.out.println(e);
        }
    }
    private static final Logger LOGGER= LogManager.getLogger(ElectricProduct.class);
    private double voltageRate;//The voltage admitted for the product in V (volts)
    private double power;//The power consumed for the product in kW (kiloWatt)
    private String electricId;//The id of the product

    private static final List<ElectricProduct> electricProductArrayList=new ArrayList<ElectricProduct>();


    //Constructor
    public ElectricProduct(String productName,String productDescription){
        super(productName,productDescription);
        this.setElectricId();
        productCounter++;
    }
    //End constructor

    //Getters and setters
    public double getVoltageRate() {
        try {
            return voltageRate;
        }catch (RuntimeException f){
            LOGGER.error("There was a runtime exception retrieving the voltage : "+f+" please try" +
                    " again later.The default value will be 0 V");
        }
        return 0;
    }

    public void setVoltageRate(double voltageRate) {
        try {
            this.voltageRate = voltageRate;
        }catch (Exception e){
                LOGGER.error("There was an error setting the voltage rate: "+e+" please try" +
                        " again later");
        }

    }

    public double getPower() {
        try {
            return power;
        }catch (RuntimeException f){
            LOGGER.error("There was a runtime exception retrieving the power : "+f+" please try" +
                    " again later");
        }catch (Exception e){
            LOGGER.error("There was an error retrieving the power : "+e+" please try" +
                    " again later");
        }
        return 0;
    }

    public void setPower(double power) {
        try {
            this.power = power;
        }catch(RuntimeException f){
            LOGGER.error("There was a runtime exception setting the power : "+f+" please try" +
                    " again later");
        }

    }

    public String getElectricId() {
        try {
            return electricId;
        } catch (RuntimeException e){
            LOGGER.error("There was an error retrieving the id : "+e+" please try" +
                    " again later the default value will be null");
        }
        return null;
    }

    public void setElectricId() {
        this.electricId = "EL"+this.hashCode();
    }

    //getter and setter to Arraylist

    public static List<ElectricProduct> getElectricProductArrayList() {
        return electricProductArrayList;
    }

    public static void setElectricProductArrayList(ElectricProduct electricProduct){
        ElectricProduct.electricProductArrayList.add(electricProduct);
    }

    //end getter and setter to Arraylist

    //end getters and setters

    //methods





    //end methods

    //override methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricProduct)) return false;
        ElectricProduct that = (ElectricProduct) o;
        return Objects.equals(electricId, that.electricId);
    }

    @Override
    public int hashCode() {
        if(Objects.hash(this.getProductName(),this.getProductDescription())<0){
            return Objects.hash(this.getProductName(),this.getProductDescription())*-1;
        }
        return Objects.hash(this.getProductName(),this.getProductDescription());
    }

    @Override
    public String toString(){
        return "The resume name of the product is:\n"+this.getProductName()
                +"\nThe full description is:\n"+this.getProductDescription();
    }


    //end override methods

    //interface methods
    @Override
    public double defineCost(double supplierCost,double transportCost,double anotherCost){
        return supplierCost+transportCost+anotherCost;
    }

    @Override
    public boolean checkAvailability(int stock) {

        stock=this.getStock();
        if (stock<=0){
            return false;
        }
        return true;
    }

    @Override
    public void removeStock(int amountSold) {
            boolean thereIsStock=this.checkAvailability(this.getStock());
            if(thereIsStock && amountSold<=this.getStock()){
            int newStock =this.getStock()-amountSold;
            this.setStock(newStock);
            LOGGER.info("your new stock of this electric product is: "+newStock);
            }else{
                LOGGER.info("you can't sell that amount of this electric product");
            }
    }


    @Override
    public LocalDate transactionDate(){
        LOGGER.info("the day of the transaction is \n" +
                LocalDate.now());
        return LocalDate.now();
    }
    //end interface methods



}
