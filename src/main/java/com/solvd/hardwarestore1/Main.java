package com.solvd.hardwarestore1;


import com.solvd.hardwarestore1.func_interfaces.ModifyAnyString;
import com.solvd.hardwarestore1.func_interfaces.OperateInEmployeeList;
import com.solvd.hardwarestore1.func_interfaces.ResultAsInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

        try (AutoCloseable ac = new AutoClosableNoResource()) {
            LOGGER.info("Inside try block to test Try catch with exception");
        } catch (Exception e) {
            LOGGER.error("An error occurred: " + e);
        }

        //Example
        LOGGER.info("Hello and welcome to hardware store!!");
        System.out.println();
        //Creating the first Electric product
        ElectricProduct lightBulb = new ElectricProduct("Light bulb 2", "led light bulb");
        //Getting the product name
        LOGGER.info(lightBulb.toString());
        //setting the power field
        lightBulb.setPower(10);
        //getting the power field
        LOGGER.info(lightBulb.getPower());
        //Using the method defineCost of the interface Costable override in Electric product
        LOGGER.info(lightBulb.defineCost(1, 0.01, 0));
        System.out.println();
        System.out.println();
        System.out.println();
        //Creating the second Electric product
        ElectricProduct lightBulb2 = new ElectricProduct("Light bulb 1", "led light bulb");

        //getting the lightBulb2 id that used hashCode override to create a unique id
        LOGGER.info(lightBulb2.getElectricId());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //Checking if lightBulb is equal to lightBulb2 to implement hashCode and equals override
        LOGGER.info(lightBulb.equals(lightBulb2));

        //Creating a new gas Product
        GasProduct gasBurner = new GasProduct("Gas Burner", "Gas kitchen burner");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("gas burner2");
        GasProduct gasBurner2 = new GasProduct("Gas Burner", "Gas kitchen burner");
        gasBurner2.setStock(8);
        gasBurner2.removeStock(5);
        LOGGER.info(gasBurner2.getStock());
        LOGGER.info(gasBurner.transactionDate());

        System.out.println();
        System.out.println();
        System.out.println();
        //Creating a product that is not part of Product, but it is part of RawMaterial super
        ConstructionProduct sand = new ConstructionProduct("Sand", "White sand", "Tn");
        //Using a method inside this class
        LOGGER.info(sand.checkLicence(true, "ABC", 3));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //Creating a new employee
        Employee carlosRusso = new Employee("carlos Russo", "123@gmail.com", "12345678", "Deposit");
        System.out.println();
        //Set vacation
        carlosRusso.setVacation(carlosRusso.seeVacation("Deposit"));
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
        Employee joseAntonio = new Employee("Jose Antonio", "123@gmail.com", "12345678", "seller");
        //Set vacation
        joseAntonio.setVacation(joseAntonio.seeVacation("seller"));
        //Check personalized exception before adding in the list
        System.out.println();
        joseAntonio.checkEmployeeData();
        System.out.println();
        //Adding this employee to the private static List employeeList
        Employee.setEmployeeList(joseAntonio);
        System.out.println();
        //Adding this employee to the private static List employeeList
        //See all the employees of the company with the info
        Employee.seeEmployeeList();
        // Creating a set list of garden product
        GardenProduct gardenScissors = new GardenProduct("Big scissors", "Big size scissors to cut grass", false);
        GardenProduct gardenScissors1 = new GardenProduct("Medium scissors", "Medium size scissors to cut grass", false);
        GardenProduct gardenScissors2 = new GardenProduct("Small scissors", "Small size scissors to cut grass", false);
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
        CustomLinkedList<String> myList = new CustomLinkedList<String>();
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
        // Input and output file paths and writing and reading exercise
        String inputFilePath = "src/main/resources/input.txt";
        String outputFilePath = "src/main/resources/output.txt";
        ReadFile.readWriteFile(inputFilePath, outputFilePath);

        //Enum access
        EmergencyExchangePhonenNumber.showNumbers();
        CurrencyExchange.changeAmount(100.50);
        BankAccounts.showBankAccounts();
        ExchangerPlatformPassword.showPasswords();
        String[] emailList = ImportantEmails.getEmails();

        //
        carlosRusso.calculateExtras(100);

        LOGGER.info(RawMaterial.separateProduct("sand", 1000, joseAntonio));


        //Custom lambda function 1

        OperateInEmployeeList<ArrayList<Employee>, ArrayList<String>> getEmployeeNameList = employeesList -> {
            ArrayList<String> list1 = new ArrayList<>();
            for (Employee employee : employeesList) {
                list1.add(employee.getPersonName());
            }
            return list1;
        };
        ArrayList<String> list2 = getEmployeeNameList.getFromEmployeeArray(Employee.getEmployeeList());
        for (String name : list2) {
            LOGGER.info(name);
        }


        //Custom lambda function 2
        ModifyAnyString<String> addRandomGoodBye = text->{
            String [] goodBye={ " .Goodbye! Take care.",
                    " .Farewell! Until we meet again.",
                    " .Adios! Wishing you the best.",};
            Random random =new Random();
            return text+goodBye[random.nextInt(2)];
        };

        LOGGER.info(addRandomGoodBye.getModifiedString("You own 22$"));

        //Custom lambda function 3
        ResultAsInteger<Employee,Employee> howManyVacationDays= (employee,employee1)->
                employee.getVacation()+employee1.getVacation();

        LOGGER.info("both employees have: "+howManyVacationDays.resultIsInteger(joseAntonio,carlosRusso)+" days of vacation");


        //Adding the new products to a product list
        ArrayList<Product> productList=new ArrayList<>();

        productList.add(gardenScissors);
        productList.add(gardenScissors1);
        productList.add(gasBurner);
        productList.add(gasBurner2);
        productList.add(lightBulb);

        //Getting an array of only electricProducts
        Stream<Product> streamElectricProducts= productList.stream();

        //1-This stream return a list of only electrical products. The list is Optional in case that there are nulls
       List<Optional<Product>> optionalProducts =  streamElectricProducts
                .filter(product->product instanceof ElectricProduct)
                .peek((product)-> System.out.println(product.getProductName()))
                .map(product -> {((ElectricProduct) product).setVoltageRate(230);
                    return Optional.of(product);})
                .collect(Collectors.toList());
        System.out.println();
        System.out.println();

        optionalProducts.forEach(product -> System.out.println(product.get().getProductName()) );
        System.out.println();

        //2- This stream use return only the product that doesnt have it voltage set and set it in 230V
        List<ElectricProduct> electricProductList=new ArrayList<>();
        electricProductList.add(lightBulb);
        electricProductList.add(lightBulb2);
        ElectricProduct lightBulb3 = new ElectricProduct("Light bulb 4", "led light bulb");


        List<ElectricProduct> electricProductList1= electricProductList.stream()
                .filter(electricProduct -> electricProduct.getVoltageRate()==0)
                .map(electricProduct -> {electricProduct.setVoltageRate(230);
                return electricProduct;})
                .collect(Collectors.toList());

        System.out.println();
        System.out.println();
        electricProductList1.
                forEach(electricProduct -> System.out.println("The product is: "+electricProduct.getProductName()+
                        " and it voltage is: "+electricProduct.getVoltageRate()));


        //

        //3-In this application of stream if we find any Electric product that doesnt has the voltage set
        //You must correct it from the beginning

        Optional<ElectricProduct> OptionalElectricProduct= electricProductList.stream()
                .filter(product->product.getVoltageRate()==0)
                .findAny();


        System.out.println(OptionalElectricProduct.orElseGet(()->{ElectricProduct defaultProduct=new ElectricProduct("Default product","There was not any product");
        return defaultProduct;}).getProductDescription());


        //4- Find unique word in text
        ReadFile.findUniqueWord("",inputFilePath);

        //5-sort words in a file by their length
        ReadFile.orderWordsbyLenght(inputFilePath,outputFilePath);

        //6 counts all the characters in a file spaces and punctuation are not counted
        ReadFile.countCharacters(inputFilePath,outputFilePath);

        //7 Find a number in a file and
        ReadFile.findAnyNumber(inputFilePath,outputFilePath);




    }
}
