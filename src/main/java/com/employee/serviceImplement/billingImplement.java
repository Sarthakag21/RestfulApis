package com.employee.serviceImplement;

import com.employee.Database.billingDatabase;
import com.employee.Entity.billingEntity;
import com.employee.serviceInterface.billingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class billingImplement implements billingInterface {
    @Autowired
    billingDatabase billingDatabase;
    @Override
    public String addCustomer(billingEntity billingEntity) {
        billingDatabase.save(billingEntity);
        return null;
    }

    @Override
    public Optional<billingEntity> customerByID(int id) {
        Optional<billingEntity> optional = billingDatabase.findById(id);
        return optional;
    }

    @Override
    public List<billingEntity> allCustomer() {
        List<billingEntity> list = billingDatabase.findAll();
        return list;
    }

    @Override
    public void deleteCustomerByID(int id) {
        billingDatabase.deleteById(id);
    }

    @Override
    public void deleteCustomer() {
        billingDatabase.deleteAll();
    }

    @Override
    public String getName(int id) {
        Optional<billingEntity> optional = billingDatabase.findById(id);
        billingEntity billingEntity1 = optional.get();
        String name = billingEntity1.getName();
        return name;
    }
}
