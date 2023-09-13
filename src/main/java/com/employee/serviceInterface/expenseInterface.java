package com.employee.serviceInterface;

import com.employee.Entity.expenseEntity;

import java.util.List;
import java.util.Optional;

public interface expenseInterface {
    public void addExpense(expenseEntity expenseEntity);
    public Optional<expenseEntity> findExpenseByID(int id);
    public List<expenseEntity> findAllExpense();
    public void deleteExpenseByID(int id);
    public void deleteAllExpense();
}
