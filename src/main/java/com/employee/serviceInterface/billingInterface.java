package com.employee.serviceInterface;

import com.employee.Entity.billingEntity;

import java.util.List;
import java.util.Optional;

public interface billingInterface {
    public String addCustomer(billingEntity billingEntity);
    public Optional<billingEntity> customerByID(int id);
    public List<billingEntity> allCustomer();
    public void deleteCustomerByID(int id);
    public void deleteCustomer();
    public String getName(int id);
    public billingEntity updateCustomer(billingEntity billingEntity, int id);
}
