package com.solvd.hardwarestore1.func_interfaces;
import com.solvd.hardwarestore1.Employee;
import java.util.ArrayList;

@FunctionalInterface
public interface OperateInEmployeeList <T extends ArrayList<Employee>,R> {
     R getFromEmployeeArray(T t);
}

