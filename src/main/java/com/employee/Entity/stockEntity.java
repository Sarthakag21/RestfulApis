package com.employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stock")
public class stockEntity {
    @Id
    private int id;
    @Column(name = "ProductName")
    private String product;
    @Column(name = "StockRecieved")
    private int stock;
    @Column(name = "StockLeft")
    private int stockLeft;
    @Column(name = "ProductManufacturingID")
    private String manufacturingID;
    @Column(name = "ProductManufacturingDate")
    private String manufacturingDate;
    @Column(name = "ProductCostPrice")
    private int cp;
    @Column(name = "ProductSellPrice")
    private int sp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public String getManufacturingID() {
        return manufacturingID;
    }

    public void setManufacturingID(String manufacturingID) {
        this.manufacturingID = manufacturingID;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }
}
