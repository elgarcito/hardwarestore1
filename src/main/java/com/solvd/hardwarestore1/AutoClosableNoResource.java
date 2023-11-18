package com.solvd.hardwarestore1;

public class AutoClosableNoResource implements AutoCloseable{

    @Override
    public void close() throws Exception{
        System.out.println("Closing without resource");
    }
}
