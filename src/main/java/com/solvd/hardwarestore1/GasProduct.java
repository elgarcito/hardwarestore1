package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;


public class GasProduct extends Product implements Costable, Available, Sellable, StockChangeable {
    private static final Logger LOGGER= LogManager.getLogger(GasProduct.class);
    private String typeOfGas;// compressed gas or natural gas
    private double gasPressure;

    private String gasId;


    //Constructor
    public GasProduct(String productName,String productDescription){
        super(productName,productDescription);
        this.setGasId();
    }

    //End constructor

    //Getter and setters
    public String getTypeOfGas() {
        return typeOfGas;
    }

    public void setTypeOfGas(String typeOfGas) {
        this.typeOfGas = typeOfGas;
    }

    public double getGasPressure() {
        return gasPressure;
    }

    public void setGasPressure(double gasPressure) {
        this.gasPressure = gasPressure;
    }

    public void setGasId(){
        this.gasId= "GS"+this.hashCode();
    }

    public String getGasId(){
        return this.gasId;
    }

    //end Getter and setters


    //methods

    //end methods
    //override methods
    @Override
    public int hashCode(){
        int code=Objects.hash(getProductName(),getProductDescription());
        if (code<0){
            return code=code*-1;
        }
        return code;
    }

    @Override
    public String toString(){
        return  "The resume name of the product is:\n"+this.getProductName()
                +"\nThe full description is:\n"+this.getProductDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GasProduct)) return false;
        GasProduct that = (GasProduct) o;
        return Objects.equals(gasId, that.gasId);
    }

    //end override methods

    //Interface methods
    @Override
    public double defineCost(double supplierCost,double transportCost,double anotherCost){
        return supplierCost+transportCost+anotherCost;
    }

    @Override
    public boolean checkAvailability(int stock) {
        stock=this.getStock();
        //You consider that your minimum stock must be 10 units if this gas product
        if (stock<=10){
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
            LOGGER.info("your new stock of this gas related product is: "+newStock+".");
        }else{
            LOGGER.info("you can't sell that amount of this gas product, you need to have at least: \n" +
                    10+" units in your stock.");
        }
    }


    @Override
    public LocalDate transactionDate(){
        LOGGER.info("the day of the transaction is");
        return LocalDate.now();
    }

    //End interface methods


}
