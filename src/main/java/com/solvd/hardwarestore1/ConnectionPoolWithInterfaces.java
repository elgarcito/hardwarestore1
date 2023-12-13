package com.solvd.hardwarestore1;

import java.util.concurrent.*;

public class ConnectionPoolWithInterfaces {
    private final BlockingQueue<MockConnection> listOfConnections;
    private static ConnectionPoolWithInterfaces instanceOfConnectionPool;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static final Integer POOL_SIZE= 5;

    private ConnectionPoolWithInterfaces (){
        listOfConnections= new LinkedBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            listOfConnections.add(MockConnection.createMockConnection());
        }
    }

    public static synchronized ConnectionPoolWithInterfaces getInstance(){
        if (ConnectionPoolWithInterfaces.instanceOfConnectionPool==null){
            instanceOfConnectionPool=new ConnectionPoolWithInterfaces();
        }
    return instanceOfConnectionPool;
    }

    public CompletionStage<MockConnection> getConnectionCompletionStage(){

        CompletableFuture<MockConnection> futureResponse=new CompletableFuture<>();
        executorService.submit(()->{
            try {
                MockConnection mockConnection = listOfConnections.take();
                futureResponse.complete(mockConnection);
            }catch (InterruptedException e){
                futureResponse.completeExceptionally(e);
            }
        });
    return futureResponse;

    }

    public void releaseConnectionCompletionStage(MockConnection mockConnection){
        listOfConnections.offer(mockConnection);
    }

    public void shutDownExecutorService() {
        executorService.shutdown();
    }


}
