package com.dxctraining.consoleapp.service;

import com.dxctraining.consoleapp.dao.IEmployeeDao;
import com.dxctraining.consoleapp.entities.Employee;
import com.dxctraining.consoleapp.exceptions.InvalidArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// transactional will inform spring that it has to open transaction at every method in this class
@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private static final Logger Log= LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private IEmployeeDao dao;

    @Override
    public Employee findEmployeeById(int id) {
       Log.info("***service class,inside findEmployeeById ,id="+id);
       Employee employee= dao.findEmployeeById(id);
        return employee;
    }


    @Override
    public Employee update(Employee employee) {
        validate(employee);
        employee=dao.update(employee);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        validate(employee);
        employee=dao.save(employee);
        return employee;
    }

    @Override
    public void remove(int id) {
       dao.remove(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public Employee findEmployeeByName(String empName) {
       Employee employee =dao.findEmployeeByName(empName);
       return employee;
    }
}
