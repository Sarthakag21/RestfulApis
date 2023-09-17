package com.employee.serviceImplement;

import com.employee.Database.billingDatabase;
import com.employee.Entity.billingEntity;
import com.employee.serviceInterface.billingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public billingEntity updateCustomer(billingEntity billingEntity, int id) {
        billingEntity billingEntity1 = billingDatabase.findById(id).get();

        if(Objects.nonNull(billingEntity.getName())
                && !"".equalsIgnoreCase(
                        billingEntity.getName())){
            billingEntity1.setName(billingEntity.getName());
        }

        if(Objects.nonNull(billingEntity.getMobile())
                && billingEntity.getMobile()!=0){
            billingEntity1.setMobile(billingEntity.getMobile());
        }

        if(Objects.nonNull(billingEntity.getEmail())
                && !"".equalsIgnoreCase(
                        billingEntity.getEmail())){
            billingEntity1.setEmail(billingEntity.getEmail());
        }

        if(Objects.nonNull(billingEntity.getBillingAddress())
                && !"".equalsIgnoreCase(
                        billingEntity.getBillingAddress())){
            billingEntity1.setBillingAddress(billingEntity.getBillingAddress());
        }

        if(Objects.nonNull(billingEntity.getShippingAddress())
                && !"".equalsIgnoreCase(
                        billingEntity.getShippingAddress())){
            billingEntity1.setShippingAddress(billingEntity.getShippingAddress());
        }

        if(Objects.nonNull(billingEntity.getProduct())
                && !"".equalsIgnoreCase(
                        billingEntity.getProduct())){
            billingEntity1.setProduct(billingEntity.getProduct());
        }

        if(Objects.nonNull(billingEntity.getPrice())
                && billingEntity.getPrice()!=0){
            billingEntity1.setPrice(billingEntity.getPrice());
        }

        if(Objects.nonNull(billingEntity.getMode())
                && !"".equalsIgnoreCase(billingEntity.getMode())){
            billingEntity.setMode(billingEntity.getMode());
        }

        return billingDatabase.save(billingEntity1);
    }
}
