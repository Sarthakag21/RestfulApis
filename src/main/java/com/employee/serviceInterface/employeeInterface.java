package com.employee.serviceInterface;

import com.employee.Entity.employeeEntity;

import java.util.List;
import java.util.Optional;

public interface employeeInterface {
    public  String welcome();
    public void addEmployee(employeeEntity employeeEntity);
    public Optional<employeeEntity> employeeById(int id);
    public List<employeeEntity> allemployee();
    public void deleteEmployeeById(int id);
    public void deleteEmployee();
    public String getName(int id);
    public employeeEntity updateEmployee(employeeEntity employeeEntity, int id);

}
