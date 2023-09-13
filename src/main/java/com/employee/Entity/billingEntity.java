package com.employee.Entity;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "Customer")
public class billingEntity {
    @Id
    private int id;
    @Column(name = "CustomerName")
    private String name;
    @Column(name = "MobileNumber")
    private long mobile;
    @Column(name = "EmailID")
    private String email;
    private String billingAddress;
    private String shippingAddress;
    @Column(name = "ProductName")
    private String product;
    @Column(name = "ProductPrice")
    private int price;
    @Column(name = "TransactionMode")
    private String mode;
    private int billNumber = randomBillNo();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int randomBillNo(){
        Random ran = new Random();
        return ran.nextInt(8999)+1000;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }
}
