package com.employee.Entity;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "Employee")
public class employeeEntity {
    @Id
    public int id;
    @Column(name = "FullName")
    private String name;
    private int age;
    @Column(name = "PhoneNumber")
    private long phone;
    @Column(name = "EmailID")
    private String mail;
    @Column(name = "AdhaarCardNumber")
    private Long adhaarCard;
    private String address;
    private int salary;
    @Column(name = "PanNumber")
    private String pan;
    private String bankName;
    @Column(name = "IfscCode")
    private String IFSC;
    private long bankNumber;
    @Column(name = "EmployeeID")
    private String EmpID = EmployeeID();

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getAdhaarCard() {
        return adhaarCard;
    }

    public void setAdhaarCard(Long adhaarCard) {
        this.adhaarCard = adhaarCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIFSC() {
        return IFSC;
    }

    public void setIFSC(String IFSC) {
        this.IFSC = IFSC;
    }

    public long getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(long bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public String EmployeeID(){
        Random ran = new Random();
        String prefix = "E";
        int id = ran.nextInt(8999)+1000;
        return prefix+id;
    }
}
