package com.dxctraining.jerseyboot.employee.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String msg){
        super(msg);
    }

}
