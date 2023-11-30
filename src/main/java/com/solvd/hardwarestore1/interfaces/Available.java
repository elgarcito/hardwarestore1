package com.solvd.hardwarestore1.interfaces;

/*
This interface let us know if there is stock available or no.
The check Availability method let us know in a boolean expression if there is or no
Stock in that product
 */
public interface Available {
    boolean checkAvailability(int stock);
}
