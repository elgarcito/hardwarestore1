# hardwarestore1
Progresive exercises of QA automation training, using maven and git.

## Project description:
In this project, we have a hardware store that sells different products.

<p align="center">
<img src="https://t4.ftcdn.net/jpg/03/39/67/57/360_F_339675724_zKIsiEcSss6x2KOXUfHMfBrK9b0qbYCQ.jpg" alt="Image of a hardware store" width="300" height="200">
</p>

We represent this product using classes.
We can see the classes and some examples of the kind of product that they are going to content:
1. ConstructionProduct: nails, screws, cement, sand etc. we sell it by it units, for ex.
10 kg of sand.
2. ElectricProduct: cables, electric tape, socket outlet,power drills, hole puncher, etc.
3. HandTool: hammer, hand saw, etc.
4. GardenProduct:shovel, plant pot, etc.
5. HouseholdItem: kettle, broom, brush, etc.
6. WaterProduct:water filter, water pump, etc.
7. GasProduct: gas valve, etc.

Besides that, we have the persons that interact with the store these are:
1. Employee: these are the employees of the store and could be: seller, deposit or owner
2. Supplier: the one that sells us the products
3. BigCLient: at the moment, the store only works with big clients that are small and registered.

## Exercises and references:

### 09/11/2023

Add 5 collections to the hierarchy.

* The five collections are:
1. electricProductArrayList in ElectricProduct class.
2. employeeList in Employee class.
3. gardenProductSetList in GardenProduct.
4. householdItemArrayList in HouseHoldItem class.
5. resumedEmployeeInformationList in Employee class.

Create custom LinkedList with generic.

* The Class CustomLinkedList is created with generics and has the methods:
* addEndNode(T data), addFirstNode(T data), deleteFirstNode(), deleteMiddleNode(T data),
 deleteLastNode(), deleteCustomLinkedList()

### 07/11/2023
Create 5 custom exceptions.

The exception added are: 
1. PhoneNumberException
2. NumberInNamesException
3. LongEmployeeNameException
4. EmployeeSpecialityException
5. EmailException

Handle exceptions in 2 ways.

* In throwNameException(String employeeName) in Class Employee we handle exception in
two ways.All other exceptions are used in the checkEmployeeData() method in Employee class
that allows us to see if the data of the employee is OK. 

Use try-catch with resources.

### * __Re-Do this exercise. We have an example in the static block in electricProduct.__

Log messages to the console, file.

* All messages that are not a white line are LOGGER.info() or LOGGER.error() type and
saved in HardwareStore.log .This is due to the implementation of log4j. The log4j2.xml is
in the resources folder.

### 02/11/2023

Add 5 interfaces to the existing hierarchy. Use polymorphism with the abstract class and interface from the hierarchy.

* The interfaces added for products that are not raw material: Selleable, Priceable, Costable, Available, StockChangeable.
These interfaces are implemented in the ElectricProduct class
* The interfaces added for Employee: VacationAble. This interface is used in the Employee class

Create final class, method, variable.

* The final class: PayingRates
* Final method: showRates() inside Employee class
* Final variable: inside PayingRates class: SELLER_RATE, DEPOSIT_RATE, OWNER_RATE.

Create a static block, method, variable.

* Static block: Inside Main class used a static block
* Static method: some of the static methods are: setEmployeeList(), seeEmployeeList(),
in Employee class, checkLicence(args) in RawMaterial Abstract class implemented in 
ConstructionProduct
* Static variable: productCounter used in ElectricProduct

### 31/10/2023

Extend your previous homework with next features:

Requirements:
Use polymorphism with at least one abstract class.

Created the abstract classes:
* Product: All products(ElectricProduct,GasProduct,etc) extends Product
* Person: All human being(Employee, Supplier, SmallClient) extends Person
* RawMaterial: ConstructionProduct extend RawMaterial

Create and override at least one abstract method.

* In Person Abstract Class we have have the abstract method:
  *  public abstract checkAge(int personAge);
  * It is overridden in Employee, Supplier and SmallClient



Use protected modifier at least 5 times:

* In Class HandTool we use 5 protected modifiers

Override methods from class Object (toString(), hashcode(), equals()) for at least 3 classes from the hierarchy.

* In Classes: ElectricProduct, GardenProduct and GasProduct

### 26/10/2023

Create a class hierarchy. Topic for your hierarchy will be provided by your mentors.

Requirements:

At least 10 classes:
* Products
  * ElectricProduct
  * GardenProduct
  * GasProduct
  * ConstructionProduct
  * HandTool
  * HouseholdItem
  * WaterProduct

* Human being
  * Employee
  * Supplier
  * BigClient

* All classes must contain properties (minimum 1)
* At least 5 private properties (in total, in any classes)
* All private variables must have getters and setters.
* All classes should have at least one custom constructor
* Create a separate class with main() which will instantiate objects of implemented classes.
