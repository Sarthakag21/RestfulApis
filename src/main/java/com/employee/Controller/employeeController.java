package com.employee.Controller;

import com.employee.Entity.employeeEntity;
import com.employee.serviceInterface.employeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class employeeController {

    @Autowired
    employeeInterface employeeInterfacefinal;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Sarthak's Enterprises";
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody employeeEntity employeeEntity){
        employeeInterfacefinal.addEmployee(employeeEntity);
        String name = employeeEntity.getName();
        int id = employeeEntity.getId();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(name+" is succusfully registered with ID "+id);
    }

    @GetMapping("/findEmployeeByID")
    public ResponseEntity<List<employeeEntity>> findById(@RequestParam int id){
        Optional<employeeEntity> optional = employeeInterfacefinal.employeeById(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            employeeEntity employee = optional.get();
            List<employeeEntity> employeeEntityList = Collections.singletonList(employee);
            return ResponseEntity.status(HttpStatus.FOUND).body(employeeEntityList);
        }
    }

    @GetMapping("/findAllEmployee")
    public ResponseEntity<List<employeeEntity>> findall(){
        List<employeeEntity> employeeEntityList = employeeInterfacefinal.allemployee();
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeEntityList);
    }

    @DeleteMapping("deleteEmployeeByID")
    public ResponseEntity<String> deleteById(@RequestParam int id){
        Optional<employeeEntity> optional = employeeInterfacefinal.employeeById(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID is wrong...");
        }else{
            String name = employeeInterfacefinal.getName(id);
            employeeInterfacefinal.deleteEmployeeById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(name+"'s data is succussfully deleted");
        }
    }

    @DeleteMapping("/deleteAllEmployee")
    public ResponseEntity<String> deleteAll(){
        employeeInterfacefinal.deleteEmployee();
        return ResponseEntity.status(HttpStatus.OK).body("Data is Succesfully Deleted");
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody employeeEntity employeeEntity, @PathVariable int id){
        Optional<employeeEntity> optional = employeeInterfacefinal.employeeById(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
        }
        else{
            employeeEntity.setId(id);
            employeeInterfacefinal.updateEmployee(employeeEntity, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully");
        }
    }

}
