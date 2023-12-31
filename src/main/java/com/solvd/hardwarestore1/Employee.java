package com.solvd.hardwarestore1;

import com.solvd.hardwarestore1.exceptions.*;
import com.solvd.hardwarestore1.interfaces.VacationAble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Employee extends Person implements VacationAble {
    private static final Logger LOGGER= LogManager.getLogger(Employee.class);
    private String personalId;//The personal id of the worker
    private double costPerHour;//The pay per hour of the worker
    private String speciality;//What kind of job the worker does

    private int employeeAge;//how old is the employee

    private String employeeOtherInfo;

    private String extraWork;

    private Integer vacation;




    //The list that saves the Object employees
    private static final ArrayList<Employee> employeeList=new ArrayList<Employee>();
    //The list with the names only, this is public
    public static final Set<String> resumedEmployeeInformationList=new HashSet<String>() {
    };

    //Constructor
    public Employee(String personName, String personEmail, String phoneNumber,String speciality) {
        super(personName, personEmail, phoneNumber);
        this.speciality=speciality;
    }
    //End constructor

    //Getter and setters
    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public void setSpeciality(String speciality){
        this.speciality=speciality;
    }

    public String getSpeciality(){
        return speciality;
    }


    //getter to the name of the object in the list
    public String getNameFromList(Employee employee){
        LOGGER.info(employeeList.contains(employee));
        return "edgar";
    }
    //Method to set an employee to the private static all the employees added
    public static void setEmployeeList(Employee employee){
        employeeList.add(employee);
        LOGGER.info("The employee "+ employee.getPersonName()+" has been added to the employee list." );
    }

    public static ArrayList<Employee> getEmployeeList(){
        //Envio una copia de la lista, no la lista misma
        return new ArrayList<>(employeeList);
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }


    public String getEmployeeOtherInfo() {
        return employeeOtherInfo;
    }

    public void setEmployeeOtherInfo(String employeeOtherInfo) {
        this.employeeOtherInfo = employeeOtherInfo;
    }

    public String getExtraWork() {
        return extraWork;
    }

    public void setExtraWork(String extraWork) {
        this.extraWork = extraWork;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

    public Integer getVacation() {
        return vacation;
    }

    //end getters and setters



    //Method implementation
    @Override
    public int seeVacation(String speciality){
        switch (speciality){
            case "Owner":
                return 35;
            case "seller":
                return 25;
            case "Deposit":
                return 15;
        }
        LOGGER.info("No valid speciality");
        return 0;
    }







    //This method allows checking if the employee name is longer than the maximum it is used to
    // define the exception
    public void throwNameException(String employeeName) throws LongEmployeeNameException, NumberInNamesException {
            if (employeeName.length()>20) {
                throw new LongEmployeeNameException("The name is too long, pleas make it less than 20 characters.");
            }else if ((employeeName.contains("0") || employeeName.contains("1") || employeeName.contains("2") || employeeName.contains("3") || employeeName.contains("4") || employeeName.contains("5") || employeeName.contains("6") || employeeName.contains("7") || employeeName.contains("8") || employeeName.contains("9"))){
                throw new NumberInNamesException("The employee name has a number, please correct it.");
            }else{
                LOGGER.info("The name length is ok and it has not any number inside");
            }
    }

    //This exception check Email
    public void throwEmailException(String employeeEmail) throws EmailException {
            if (!employeeEmail.contains("@gmail.com") ) {
                throw new EmailException("Please only use a @gmail.com email.");
            } else {
                LOGGER.info("The gmail format is OK, only gmail mails.");
            }
    }
    //This exception checks the phone number length
    public void throwPhoneNumberException(String employeePhoneNumber) throws PhoneNumberException {
            if (employeePhoneNumber.length()==8) {
                LOGGER.info("The 8 digit phone number is Ok.");
            } else {
                throw new PhoneNumberException("The phone number has " + employeePhoneNumber.length()
                        + " digits and should be 8 digits");
            }
    }

    //This exception checks the speciality
    public void throwEmployeeSpecialityException(String employeeSpeciality) throws EmployeeSpecialityException {
            if (employeeSpeciality.equals("seller")|| employeeSpeciality.equals("owner") || employeeSpeciality.equals("deposit")) {
                LOGGER.info("The specialty "+employeeSpeciality+" is Ok.");
            }else {
                throw new EmployeeSpecialityException("The speciality"+ employeeSpeciality+" doesn't exist, please " +
                        "enter a valid one: seller or deposit.");
            }
    }

    //Now the method that uses the try catch and in which we use the exception.
    // This is the one that is going to be used in Main
    public void checkEmployeeData(){
        try {
            throwNameException(this.getPersonName());
            throwEmailException(this.getPersonEmail());
            throwPhoneNumberException(this.getPhoneNumber());
            throwEmployeeSpecialityException(this.speciality);
        }catch (EmployeeSpecialityException | EmailException |NumberInNamesException
                |LongEmployeeNameException| PhoneNumberException e){
            LOGGER.error(e);
        }

    }

    //This method allows iterating in the employeeList and retrieving the names of the employees
    public static void seeEmployeeList(){
        for (Employee employee:Employee.getEmployeeList()) {
            //System.out.println();
            String resumedInfo="\nName: "+employee.getPersonName()+
                    "\nSpeciality: "+ employee.getSpeciality()+
                    "\nPhone number: "+employee.getPhoneNumber();
            //Saving the resumed names in another string with arrays
            Employee.resumedEmployeeInformationList.add(resumedInfo);
        }
        for (String resumedNames:Employee.resumedEmployeeInformationList) {
            System.out.println();
            LOGGER.info(resumedNames);
        }
    }

    //Show the rates per hour according to the type of employee
    final void showRates(){
        String message = "The rates per hour according to speciality are: \n" +
                "Seller: "+ PayingRates.getSELLER_RATE()+" USD/h"+
                "\nDeposit employee: "+PayingRates.getDEPOSIT_RATE()+" USD/h"+
                "\nOwner: "+PayingRates.getOWNER_RATE()+" USD/h";
        LOGGER.info(message);
    }

    //This method give us extra pays due to sales
    public String calculateExtras(int amountSold){
       Integer amountSelled1= amountSold;

        Function<Integer,String> calculateSold= result->{
          if (result>=50 && result<100){
              LOGGER.info("The extra pay for: "+this.getPersonName() +" is 50 usd$");
              return "The extra pay for: "+this.getPersonName() +" is 50 usd$";
          }else if (result>=100 && result<150){
              LOGGER.info("The extra pay for: "+this.getPersonName() +" is 150 usd$");
              return "The extra pay for: "+this.getPersonName() +" is 150 usd$";
          }else if (result>=150){
              LOGGER.info("The extra pay for: "+this.getPersonName() +" is 250 usd$");
              return "The extra pay for: "+this.getPersonName() +" is 250 usd$";
          }
          return "No extra payment";
          };

        return calculateSold.apply(amountSelled1);
    }


    ;










    //end methods
    //Override abstract method
    @Override
    public void checkAge(){
        if (this.getEmployeeAge()<21){
            LOGGER.info("You must be older than 18 years to be an employee.");
            if (this.employeeAge==0){
                LOGGER.info("Please set the employee age.");
            }
        }else {
            LOGGER.info("You can be an employee.");
        }
    }
    //End override abstract method



}
