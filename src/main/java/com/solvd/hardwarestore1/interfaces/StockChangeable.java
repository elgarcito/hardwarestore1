package com.solvd.hardwarestore1.interfaces;

import java.time.LocalDate;

public interface StockChangeable extends Sellable, Available {
    default LocalDate transactionDate(){
        return LocalDate.now();
    }
}
