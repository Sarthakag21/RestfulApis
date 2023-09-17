package com.employee.Controller;

import com.employee.Entity.stockEntity;
import com.employee.serviceInterface.stockInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class stockController {
    @Autowired
    stockInterface stockInterfacefinal;
    @PostMapping("/addStock")
    public ResponseEntity<String> addStock(@RequestBody stockEntity stockEntity){
        stockInterfacefinal.addStock(stockEntity);
        int id = stockEntity.getId();
        String product = stockEntity.getProduct();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product+" has been added to stock list with id : "+id);
    }

    @GetMapping("/findStockByID")
    public ResponseEntity<List<stockEntity>> findStock(@RequestParam int id){
        Optional<stockEntity> optional = stockInterfacefinal.stockByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else{
            stockEntity stock = optional.get();
            List<stockEntity> stockEntityList = Collections.singletonList(stock);
            return ResponseEntity.status(HttpStatus.FOUND).body(stockEntityList);
        }
    }

    @GetMapping("/findAllStock")
    public ResponseEntity<List<stockEntity>> findAll(){
        List<stockEntity> stockEntityList = stockInterfacefinal.allStock();
        return ResponseEntity.status(HttpStatus.FOUND).body(stockEntityList);
    }

    @DeleteMapping("/deleteStockByID")
    public ResponseEntity<String> deleteStock(@RequestParam int id){
        Optional<stockEntity> optional = stockInterfacefinal.stockByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else{
            String product = stockInterfacefinal.getProduct(id);
            stockInterfacefinal.deleteStockByID(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(product+" has been successfully deleted from the stock list");
        }
    }

    @DeleteMapping("/deleteAllStock")
    public ResponseEntity<String> deleteAll(){
        stockInterfacefinal.deleteAllStock();
        return ResponseEntity.status(HttpStatus.OK).body("Stock data is successfully deleted.");
    }

    @PutMapping("/updateStock/{id}")
    public ResponseEntity<String> updateStock(@RequestBody stockEntity stockEntity, @PathVariable int id){
        Optional<stockEntity> optional = stockInterfacefinal.stockByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
        }
        else{
            stockEntity.setId(id);
            stockInterfacefinal.updateStock(stockEntity, id);
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully");
        }
    }
}
