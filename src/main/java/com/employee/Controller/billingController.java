package com.employee.Controller;

import com.employee.Entity.billingEntity;
import com.employee.serviceInterface.billingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class billingController {
    @Autowired
    billingInterface billingInterfacefinal;
    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody billingEntity billingEntity){
        billingInterfacefinal.addCustomer(billingEntity);
        int id = billingEntity.getId();
        String name = billingEntity.getName();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(name+" your data has been successfully stored with id : "+id);
    }
    @GetMapping("/findCustomerByID")
    public ResponseEntity<List<billingEntity>> findCustomer(@RequestParam int id){
        Optional<billingEntity> optional = billingInterfacefinal.customerByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            billingEntity billing = optional.get();
            List<billingEntity> billingEntityList = Collections.singletonList(billing);
            return ResponseEntity.status(HttpStatus.FOUND).body(billingEntityList);
        }
    }
    @GetMapping("/findAllCustomer")
    public ResponseEntity<List<billingEntity>> findAll(){
        List<billingEntity> billingEntityList = billingInterfacefinal.allCustomer();
        return ResponseEntity.status(HttpStatus.FOUND).body(billingEntityList);
    }
    @DeleteMapping("/deleteCustomerByID")
    public ResponseEntity<String> deleteCustomer(@RequestParam int id){
        Optional<billingEntity> optional = billingInterfacefinal.customerByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            String name = billingInterfacefinal.getName(id);
            billingInterfacefinal.deleteCustomerByID(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(name+" record is successfully deleted");
        }
    }
    @DeleteMapping("/deleteAllCustomer")
    public ResponseEntity<String> deleteAll(){
        billingInterfacefinal.deleteCustomer();
        return ResponseEntity.status(HttpStatus.OK).body("All record deleted");
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<String> updateCustomer(@RequestBody billingEntity billingEntity, @PathVariable int id){
        Optional<billingEntity> optional = billingInterfacefinal.customerByID(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
        }
        else{
            billingEntity.setId(id);
            billingInterfacefinal.updateCustomer(billingEntity, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully");
        }
    }
}
