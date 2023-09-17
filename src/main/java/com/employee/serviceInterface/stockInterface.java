package com.employee.serviceInterface;

import com.employee.Entity.stockEntity;

import java.util.List;
import java.util.Optional;

public interface stockInterface {
    public void addStock(stockEntity stockEntity);
    public Optional<stockEntity> stockByID(int id);
    public List<stockEntity> allStock();
    public void deleteStockByID(int id);
    public void deleteAllStock();
    public String getProduct(int id);
    public stockEntity updateStock(stockEntity stockEntity, int id);
}
