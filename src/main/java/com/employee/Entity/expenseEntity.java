package com.employee.Entity;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Expense")
public class expenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "Expenses")
    private int expense;
    @Column(name = "DateOfExpense")
    private String expenseDate = date();
    @Column(name = "PaymentMode")
    private String mode;
    @Column(name = "DescriptionOfExpense")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String date(){
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy");
        Date obj = new Date();
        return (dfor.format(obj));
    }
}
