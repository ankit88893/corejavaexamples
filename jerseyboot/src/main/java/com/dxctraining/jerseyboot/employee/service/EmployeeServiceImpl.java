package com.dxctraining.jerseyboot.employee.service;

import com.dxctraining.jerseyboot.employee.dao.IEmployeeDao;
import com.dxctraining.jerseyboot.employee.entities.Employee;
import com.dxctraining.jerseyboot.employee.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// transactional will inform spring that it has to open transaction at every method in this class
@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeDao dao;

    @Override
    public Employee findEmployeeById(int id) {
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

    @Override
    public List<Employee> allEmployees(){
        List<Employee>employees=dao.allEmployees();
        return employees;
    }

    @Override
    public boolean authenticate(int id, String password){
       Employee employee= dao.findEmployeeById(id);
       String storedPassword=employee.getPassword();
       boolean equals= storedPassword.equals(password);
       return equals;
    }

    @Override
    public List<Employee> allEmployeesByDepartment(int deptId){
        List<Employee>list=dao.allEmployeesByDepartment(deptId);
        return list;
    }

}
