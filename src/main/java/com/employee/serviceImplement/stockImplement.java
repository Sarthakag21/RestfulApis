package com.employee.serviceImplement;

import com.employee.Database.stockDatabase;
import com.employee.Entity.stockEntity;
import com.employee.serviceInterface.stockInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class stockImplement implements stockInterface {
    @Autowired
    stockDatabase stockDatabase;

    @Override
    public void addStock(stockEntity stockEntity) {
        stockDatabase.save(stockEntity);
    }

    @Override
    public Optional<stockEntity> stockByID(int id) {
        return stockDatabase.findById(id);
    }

    @Override
    public List<stockEntity> allStock() {
        return stockDatabase.findAll();
    }

    @Override
    public void deleteStockByID(int id) {
        stockDatabase.deleteById(id);
    }

    @Override
    public void deleteAllStock() {
        stockDatabase.deleteAll();
    }

    @Override
    public String getProduct(int id) {
        Optional<stockEntity> stockEntity = stockDatabase.findById(id);
        com.employee.Entity.stockEntity stockEntity1 = stockEntity.get();
        return stockEntity1.getProduct();
    }
}
