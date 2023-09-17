package com.employee.serviceImplement;

import com.employee.Entity.employeeEntity;
import com.employee.serviceInterface.employeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.Database.employeeDatabase;

import java.util.List;
import java.util.Objects;
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

    @Override
    public employeeEntity updateEmployee(employeeEntity employeeEntity, int id) {
        employeeEntity employeeEntity1 = employeeDatabase.findById(id).get();

        if(Objects.nonNull(employeeEntity.getName())
                &&!"".equalsIgnoreCase(
                        employeeEntity.getName())){
            employeeEntity1.setName(employeeEntity.getName());
        }

        if(Objects.nonNull(employeeEntity.getAge())
                && employeeEntity.getAge()!=0){
            employeeEntity1.setAge(employeeEntity.getAge());
        }

        if(Objects.nonNull(employeeEntity.getPhone())
                && employeeEntity.getPhone()!=0){
            employeeEntity1.setPhone(employeeEntity.getPhone());
        }

        if(Objects.nonNull(employeeEntity.getMail())
                && !"".equalsIgnoreCase(
                        employeeEntity.getMail())){
            employeeEntity1.setMail(employeeEntity.getMail());
        }

        if(Objects.nonNull(employeeEntity.getAdhaarCard())
                && employeeEntity.getAdhaarCard()!=0){
            employeeEntity1.setAdhaarCard(employeeEntity.getAdhaarCard());
        }

        if(Objects.nonNull(employeeEntity.getAddress())
                && !"".equalsIgnoreCase(
                        employeeEntity.getAddress())){
            employeeEntity1.setAddress(employeeEntity.getAddress());
        }

        if(Objects.nonNull(employeeEntity.getSalary())
                && employeeEntity.getSalary()!=0){
            employeeEntity1.setSalary(employeeEntity.getSalary());
        }

        if(Objects.nonNull(employeeEntity.getPan())
                &&!"".equalsIgnoreCase(
                        employeeEntity.getPan())){
            employeeEntity1.setPan(employeeEntity.getPan());
        }

        if(Objects.nonNull(employeeEntity.getBankName())
                &&!"".equalsIgnoreCase(
                        employeeEntity.getBankName())){
            employeeEntity1.setBankName(employeeEntity.getBankName());
        }

        if(Objects.nonNull(employeeEntity.getIfsc())
                && !"".equalsIgnoreCase(
                        employeeEntity.getIfsc())){
            employeeEntity1.setIfsc(employeeEntity.getIfsc());
        }

        if(Objects.nonNull(employeeEntity.getBankNumber())
                && employeeEntity.getBankNumber()!=0){
            employeeEntity1.setBankNumber(employeeEntity.getBankNumber());
        }

        return employeeDatabase.save(employeeEntity1);
    }
}
