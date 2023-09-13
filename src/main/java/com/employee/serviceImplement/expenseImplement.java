package com.employee.serviceImplement;

import com.employee.Database.expenseDatabase;
import com.employee.Entity.expenseEntity;
import com.employee.serviceInterface.expenseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class expenseImplement implements expenseInterface {
    @Autowired
    expenseDatabase expenseDatabase;

    @Override
    public void addExpense(expenseEntity expenseEntity) {
        expenseDatabase.save(expenseEntity);
    }

    @Override
    public Optional<expenseEntity> findExpenseByID(int id) {
        return expenseDatabase.findById(id);
    }

    @Override
    public List<expenseEntity> findAllExpense() {
        return expenseDatabase.findAll();
    }

    @Override
    public void deleteExpenseByID(int id) {
        expenseDatabase.deleteById(id);
    }

    @Override
    public void deleteAllExpense() {
        expenseDatabase.deleteAll();
    }
}
