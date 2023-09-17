package com.employee.Controller;

import com.employee.Entity.expenseEntity;
import com.employee.serviceInterface.expenseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class expenseController {
    @Autowired
    expenseInterface expenseInterfacefinal;
    @PostMapping("/addExpense")
    public ResponseEntity<String> addExpense(@RequestBody expenseEntity expenseEntity){
        expenseInterfacefinal.addExpense(expenseEntity);
        int id  = expenseEntity.getId();
        int expense = expenseEntity.getExpense();
        String des = expenseEntity.getDescription();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(des+" of value Rs."+expense+" has been added in data with id : "+id);
    }

    @GetMapping("/findExpenseByID")
    public ResponseEntity<List<expenseEntity>> findExpenseByID(@RequestParam int id){
        Optional<expenseEntity> optional = expenseInterfacefinal.findExpenseByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            expenseEntity expenseEntity = optional.get();
            List<expenseEntity> expenseEntityList = Collections.singletonList(expenseEntity);
            return ResponseEntity.status(HttpStatus.FOUND).body(expenseEntityList);
        }
    }

    @GetMapping("/findAllExpense")
    public ResponseEntity<List<expenseEntity>> findAll(){
        List<expenseEntity> expenseEntityList = expenseInterfacefinal.findAllExpense();
        return ResponseEntity.status(HttpStatus.FOUND).body(expenseEntityList);
    }

    @DeleteMapping("/deleteExpenseByID")
    public ResponseEntity<String> deleteExpenseByID(@RequestParam int id){
        Optional<expenseEntity> optional = expenseInterfacefinal.findExpenseByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            expenseEntity expenseEntity = optional.get();
            int expense = expenseEntity.getExpense();
            String des = expenseEntity.getDescription();
            expenseInterfacefinal.deleteExpenseByID(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(des+" of value Rs."+expense+" has been deleted from data");
        }
    }

    @DeleteMapping("/deleteAllExpense")
    public ResponseEntity<String> deleteAllExpense(){
        expenseInterfacefinal.deleteAllExpense();
        return ResponseEntity.status(HttpStatus.OK).body("All data deleted");
    }

    @PutMapping("/updateExpense/{id}")
    public ResponseEntity<String> updateExpense(@RequestBody expenseEntity expenseEntity, @PathVariable int id) {
        // First, check if the entity with the given ID exists in the database
        Optional<expenseEntity> optional = expenseInterfacefinal.findExpenseByID(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
        }
        else{
            // Set the ID of the updatedExpense to match the path variable ID
            expenseEntity.setId(id);
            // Save the updated expense to the database
            expenseInterfacefinal.updateExpense(expenseEntity, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully");
        }
    }
}
