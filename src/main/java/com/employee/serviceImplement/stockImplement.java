package com.employee.serviceImplement;

import com.employee.Database.stockDatabase;
import com.employee.Entity.stockEntity;
import com.employee.serviceInterface.stockInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public stockEntity updateStock(stockEntity stockEntity, int id) {
        stockEntity stockEntity1 = stockDatabase.findById(id).get();

        if(Objects.nonNull(stockEntity.getProduct())
                && !"".equalsIgnoreCase(
                        stockEntity.getProduct())){
            stockEntity1.setProduct(stockEntity.getProduct());
        }

        if(Objects.nonNull(stockEntity.getStock())
                && stockEntity.getStock()!=0){
            stockEntity1.setStock(stockEntity.getStock());
        }

        if(Objects.nonNull(stockEntity.getStockLeft())
                && stockEntity.getStockLeft()!=0){
            stockEntity1.setStockLeft(stockEntity.getStockLeft());
        }

        if(Objects.nonNull(stockEntity.getManufacturingID())
                && !"".equalsIgnoreCase(
                        stockEntity.getManufacturingID())){
            stockEntity1.setManufacturingID(stockEntity.getManufacturingID());
        }

        if(Objects.nonNull(stockEntity.getManufacturingDate())
                && !"".equalsIgnoreCase(
                        stockEntity.getManufacturingDate())){
            stockEntity1.setManufacturingDate(stockEntity.getManufacturingDate());
        }

        if(Objects.nonNull(stockEntity.getCp())
                && stockEntity.getCp()!=0){
            stockEntity1.setCp(stockEntity.getCp());
        }

        if(Objects.nonNull(stockEntity.getSp())
                && stockEntity.getSp()!=0){
            stockEntity1.setSp(stockEntity.getSp());
        }
        return stockDatabase.save(stockEntity1);
    }
}
