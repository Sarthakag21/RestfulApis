package com.employee.serviceImplement;

import com.employee.Entity.employeeEntity;
import com.employee.serviceInterface.employeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.Database.employeeDatabase;

import java.util.List;
import java.util.Optional;
@Service
public class employeeImplement implements employeeInterface {

   @Autowired
   employeeDatabase employeeDatabase;

    @Override
    public String welcome() {
        return null;
    }

    @Override
    public void addEmployee(employeeEntity employeeEntity) {
        employeeDatabase.save(employeeEntity);
    }

    @Override
    public Optional<employeeEntity> employeeById(int id) {
       Optional<employeeEntity> optional = employeeDatabase.findById(id);
        return optional;
    }

    @Override
    public List<employeeEntity> allemployee() {
       List<employeeEntity> employeeEntityList = employeeDatabase.findAll();
       return employeeEntityList;
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeDatabase.deleteById(id);
    }

    @Override
    public void deleteEmployee() {
       employeeDatabase.deleteAll();
    }

    @Override
    public String getName(int id) {
        Optional<employeeEntity> employeeEntity = employeeDatabase.findById(id);
        com.employee.Entity.employeeEntity employeeEntity1 =  employeeEntity.get();
        String name = employeeEntity1.getName();
        return name;
    }
}
