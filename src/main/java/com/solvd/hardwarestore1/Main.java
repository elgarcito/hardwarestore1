package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.ExecutorService;


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

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {

        //Two threads

        System.out.println("Hello from main");
        //Thread with runnable
        ThreadWithRunnable threadWithRunnable = new ThreadWithRunnable();
        (new Thread(threadWithRunnable)).start();
        //Thread with extends of Thread
        (new ThreadWithThread()).start();
        System.out.println("Bye from main");

        //Connection pool with threads
        List<Thread> listOfThreads = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        for (int i = 0; i < 5; i++) {
            Thread newTread = new Thread(new ThreadWithRunnable1(connectionPool));
            newTread.start();
            listOfThreads.add(newTread);
        }


        for (int i = 2; i < 5; i++) {
            Thread newThread = new Thread(new ThreadWithRunnable1(connectionPool));
            newThread.start();
            listOfThreads.add(newThread);
        }

        for (Thread newThread : listOfThreads) {
            newThread.join();
        }


        ConnectionPoolWithInterfaces connectionPoolWithInterfaces = ConnectionPoolWithInterfaces.getInstance();
        //Connection pool with Ifuture interface
        for (int i = 0; i < 7; i++) {
            connectionPoolWithInterfaces.getConnectionCompletionStage()
                    .thenAccept(connection -> {
                        LOGGER.info(Thread.currentThread().getName() + " got connection with completable Stage: " + connection);
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            LOGGER.error(e.getMessage());
                        }
                        connectionPoolWithInterfaces.releaseConnectionCompletionStage(connection);
                        LOGGER.info(Thread.currentThread().getName() + " released connection with completable Stage: " + connection);
                    })
                    .exceptionally(throwable -> {

                        throwable.printStackTrace();
                        return null;
                    });
        }
        connectionPoolWithInterfaces.shutDownExecutorService();
    }
}





