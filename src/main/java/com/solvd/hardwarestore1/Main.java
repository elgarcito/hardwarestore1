package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/*Hardware store
In this project, we have a hardware store that sells different products.
We represent this product using classes.
Now we can se the classes and some examples of the kind of product that they are going to content:
1-ConstructionProduct: nails, screws, cement, sand etc. we sell it by it units, for ex.
10 kg of sand
2-ElectricProduct: cables, electric tape, socket outlet,power drills, hole puncher, etc.
3-HandTool: hammer, hand saw
4-GardenProduct:shovel, plant pot
5-HouseholdItem: kettle, broom, brush
6-WaterProduct:water filter, water pump
7-GasProduct: gas valve,etc

Also, we have:
Employee: the employee of the store.
Supplier: the one that sells the product.
Client: the one that buys the product.

We are going to find the full characteristic within each class

 */
public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private static final Logger LOGGER= LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        //Example
        LOGGER.info("Hello and welcome to hardware store!!");
        System.out.println();
        //Creating the first Electric product
        ElectricProduct lightBulb=new ElectricProduct("Light bulb","led light bulb");
        //Getting the product name
        LOGGER.info(lightBulb.toString());
        //setting the power field
        lightBulb.setPower(10);
        //getting the power field
        LOGGER.info(lightBulb.getPower());
        //Using the method defineCost of the interface Costable override in Electric product
        LOGGER.info(lightBulb.defineCost(1,0.01,0));
        System.out.println();
        System.out.println();
        System.out.println();
        //Creating the second Electric product
        ElectricProduct lightBulb2=new ElectricProduct("Light bulb","led light bulb");

        //getting the lightBulb2 id that used hashCode override to create a unique id
        LOGGER.info(lightBulb2.getElectricId());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //Checking if lightBulb is equal to lightBulb2 to implement hashCode and equals override
        LOGGER.info(lightBulb.equals(lightBulb2));

        //Creating a new gas Product
        GasProduct gasBurner=new GasProduct("Gas Burner","Gas kitchen burner");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("gas burner2");
        GasProduct gasBurner2=new GasProduct("Gas Burner","Gas kitchen burner");
        gasBurner2.setStock(8);
        gasBurner2.removeStock(5);
        LOGGER.info(gasBurner2.getStock());
        LOGGER.info(gasBurner.transactionDate());

        System.out.println();
        System.out.println();
        System.out.println();
        //Creating a product that is not part of Product, but it is part of RawMaterial super
        ConstructionProduct sand =new ConstructionProduct("Sand","White sand","Tn");
        //Using a method inside this class
        LOGGER.info(sand.checkLicence(true,"ABC",3));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //Creating a new employee
        Employee carlosRusso=new Employee("carlos1","123@gmail.com","12345678","seller");
        System.out.println();
        //Check personalized exception
        carlosRusso.checkEmployeeData();
        //End check personalized exception
        System.out.println();
        //Adding this employee to the private static List employeeList
        Employee.setEmployeeList(carlosRusso);
        //Eng adding this employee to the private static List employeeList
        System.out.println();
        System.out.println();
        System.out.println();
        //Creating a new employee
        Employee carlosRusso2=new Employee("Jose Antonio","123@gmail.com","12345678","seller");
        //Check personalized exception before adding in the list
        System.out.println();
        carlosRusso2.checkEmployeeData();
        System.out.println();
        //Adding this employee to the private static List employeeList
        Employee.setEmployeeList(carlosRusso2);
        System.out.println();
        //Adding this employee to the private static List employeeList
        //See all the employees of the company with the info
        Employee.seeEmployeeList();
        // Creating a set list of garden product
        GardenProduct gardenScissors=new GardenProduct("Big scissors","Big size scissors to cut grass",false);
        GardenProduct gardenScissors1=new GardenProduct("Medium scissors","Medium size scissors to cut grass",false);
        GardenProduct gardenScissors2=new GardenProduct("Small scissors","Small size scissors to cut grass",false);
        //Adding the products to the setList gardenProductSetList and checking that it cant set duplicate objects
        GardenProduct.setGardenProductSetList(gardenScissors);
        GardenProduct.setGardenProductSetList(gardenScissors);
        GardenProduct.setGardenProductSetList(gardenScissors1);
        GardenProduct.setGardenProductSetList(gardenScissors1);
        GardenProduct.setGardenProductSetList(gardenScissors2);
        GardenProduct.setGardenProductSetList(gardenScissors2);
        //See the garden products data
        GardenProduct.seeGardenProductList();

        System.out.println(Employee.resumedEmployeeInformationList);

        //Interacting with the CustomLinkedList

        //Trying the CustomLinkedList With generics
        CustomLinkedList<String> myList=new CustomLinkedList<String>();
        myList.addEndNode("1");
        myList.addEndNode("2");
        myList.addEndNode("5");
        myList.addEndNode("6");
        //Printing all the data
        myList.printAllData();
        System.out.println();
        //Deleting the firstNode
        myList.deleteFirstNode();
        System.out.println();
        myList.printAllData();
        System.out.println();
        //Deleting an element in middle of the Customlinked list
        myList.deleteMiddleNode("5");
        //Adding a firstNode
        myList.addFirstNode("7");
        System.out.println();
        myList.printAllData();
        System.out.println();
        //deleting the lastNode of the last part
        myList.deleteLastNode();
        myList.deleteLastNode();
        myList.deleteFirstNode();
        System.out.println();
        myList.printAllData();
        //Delete the whole list
        myList.addEndNode("1");
        myList.addEndNode("2");
        myList.addEndNode("5");
        myList.addEndNode("6");
        System.out.println();
        myList.printAllData();
        myList.deleteCustomLinkedList();
        myList.printAllData();

        // END Interacting with the CustomLinkedList

        /* Interacting with CustomLinkedList using an object
        CustomLinkedList<ElectricProduct> electricProductCustomLinkedList= new CustomLinkedList<>();
        ElectricProduct lightBulb3=new ElectricProduct("Light bulb3","led light bulb");
        ElectricProduct lightBulb4=new ElectricProduct("Light bulb4","led light bulb");
        ElectricProduct lightBulb5=new ElectricProduct("Light bulb4","led light bulb");
        ElectricProduct lightBulb6=new ElectricProduct("Light bulb6","led light bulb");
        ElectricProduct lightBulb7=new ElectricProduct("Light bulb7","led light bulb");
        electricProductCustomLinkedList.addFirstNode(lightBulb3);
        electricProductCustomLinkedList.addEndNode(lightBulb4);
        electricProductCustomLinkedList.addEndNode(lightBulb5);
        electricProductCustomLinkedList.addEndNode(lightBulb6);
        electricProductCustomLinkedList.addEndNode(lightBulb7);
        electricProductCustomLinkedList.deleteFirstNode();
        electricProductCustomLinkedList.deleteMiddleNode(lightBulb5);
        electricProductCustomLinkedList.printAllData();

         */


    }
}