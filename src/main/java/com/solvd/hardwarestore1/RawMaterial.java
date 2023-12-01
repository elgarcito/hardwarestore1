package com.solvd.hardwarestore1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Here we have the kind of product that tou can use to make another, for example, sand, gasoline
//or all the kind of product that you don't sell by unit
public abstract class RawMaterial {

    private String rawMaterialName;
    private String rawMaterialDescription;
    private String unitType;//For example a ton, kg, lt


    //Constructor
    public RawMaterial(String rawMaterialName,String rawMaterialDescription,String unitType){
        this.rawMaterialName=rawMaterialName;
        this.rawMaterialDescription=rawMaterialDescription;
    }
    //End constructor

    //Getter and setter

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public String getRawMaterialDescription() {
        return rawMaterialDescription;
    }

    public void setRawMaterialDescription(String rawMaterialDescription) {
        this.rawMaterialDescription = rawMaterialDescription;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }


    //end getter and setter

    //Methods
    /*
    This method tell us if we need a special license to buy that product using the licence of the product according
    to the type of product, for example: some kind of poison. This method should be override because the licences
    rules to be valid shoul follow different rules like AB1254 or 129842ZTE
     */
    public abstract boolean checkLicence(boolean needLicense,String licenseId, int licenseNumberLength);
    //end methods

    public static String separateProduct(String materialType, double amount ,Employee employee){
        if (amount==0 | !materialType.equals("sand") & !materialType.equals("gasoline")) {
            return "there was no product amount added, or the option isnt sand or gasoline please correct it.";
        }

        if(amount<10){
            return "The minimun amount of gasoline is 10 lts";
        } else if (amount<100 & materialType.equals("sand")) {
            return "The minimun amount of sand  is 100 kgr";
        }


        //define the function interface
        Function<String,Integer> dividedProduct= typeOfProduct ->{
            if (typeOfProduct.equals("sand")||typeOfProduct.equals("Sand")){
                //A bag of 100 kg
                return 100;
            } else if (typeOfProduct.equals("gasoline")||typeOfProduct.equals("Gasoline")) {
                //In special recipents of 10 lts.
                return 10;
            }
            return 0;
        };

        BiFunction<String,Integer,Integer> hoursOfWork=(typeOfProduct,amountOfUnits)->{
            if (typeOfProduct.equals("sand")||typeOfProduct.equals("Sand")){
                //30 minutes to prepare every bag with sand
              return (amountOfUnits*10);
            } else if (typeOfProduct.equals("gasoline")||typeOfProduct.equals("Gasoline")) {
                //5 minutes to prepare every bag with sand
                return  (amountOfUnits*5);
            }
            return  0;
        };

        Predicate<Integer> checkWorkers =hours-> {
            //if the time is below 120 min(2 hours) it can be done by a single employee
            return (hours<=120);
        };

        BiConsumer<Employee,Integer> assignWorkToEmployee=(employee1,extraHours)->{
            String message ="You have been asigned with "+extraHours+" min of extra " +
                    "work ask the manager for details" ;
            employee1.setExtrawork(message);
        };

        Supplier<LocalDateTime> transactionDate =()-> LocalDateTime.now();

        Integer unitsProduct =dividedProduct.apply(materialType);


        Double divisionResult= amount/dividedProduct.apply(materialType);
        Integer roundDivision=divisionResult.intValue();
        Integer hoursWorked=hoursOfWork.apply(materialType,roundDivision);
        if(!checkWorkers.test(hoursWorked)){
            return "This job must be done by two persons please talk to the manager";
        };
        assignWorkToEmployee.accept(employee,hoursWorked);
        return "The work was assigned to "+employee.getPersonName()+".The date: " +transactionDate.get()+ ".\n" +
                "She/He must do: "+ roundDivision+ " bags or recipents of "+ materialType+ ".\n" +
                "with an estimated time of: "+hoursWorked+" min.";
    }

}
