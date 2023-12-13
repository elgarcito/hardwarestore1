package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private final BlockingQueue<MockConnection> CONNECTION_LIST;
    private static volatile ConnectionPool instanceOfConnectionPool;

    private static final int POOl_SIZE=5;

    //creating a private constructor to start the conection pool.
    private ConnectionPool(){
        CONNECTION_LIST=new LinkedBlockingQueue<>(POOl_SIZE);
        for (int i = 0; i < POOl_SIZE; i++) {
            CONNECTION_LIST.add(MockConnection.createMockConnection());
        }
    }

    //Using singleton pattern
    public synchronized static ConnectionPool getInstance(){
      if(instanceOfConnectionPool==null){
          instanceOfConnectionPool=new ConnectionPool();
      }
      return instanceOfConnectionPool;
    };

    public synchronized MockConnection getConnection() throws InterruptedException {
        return CONNECTION_LIST.take();
    };

    public  void  releaseConnection(MockConnection mockConnection){
       CONNECTION_LIST.offer(mockConnection);
    }






}
