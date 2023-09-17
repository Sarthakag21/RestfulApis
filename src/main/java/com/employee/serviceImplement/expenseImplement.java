package com.employee.serviceImplement;

import com.employee.Database.expenseDatabase;
import com.employee.Entity.expenseEntity;
import com.employee.serviceInterface.expenseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public expenseEntity updateExpense(expenseEntity expenseEntity, int id) {
        expenseEntity expenseEntity1 = expenseDatabase.findById(id).get();

        if (Objects.nonNull(expenseEntity.getDescription())
                && !"".equalsIgnoreCase(
                expenseEntity.getDescription())) {
            expenseEntity1.setDescription(expenseEntity.getDescription());
        }

        if (Objects.nonNull(expenseEntity.getMode())
                && !"".equalsIgnoreCase(
                expenseEntity.getMode())) {
            expenseEntity1.setMode(expenseEntity.getMode());
        }

        if (Objects.nonNull(expenseEntity.getExpenseDate())
                && !"".equalsIgnoreCase(
                expenseEntity.getExpenseDate())) {
            expenseEntity1.setExpenseDate(expenseEntity.getExpenseDate());
        }

        if (Objects.nonNull(expenseEntity.getExpense()) && expenseEntity.getExpense() != 0) {
            expenseEntity1.setExpense(expenseEntity.getExpense());
        }

        return expenseDatabase.save(expenseEntity1);
    }
}
