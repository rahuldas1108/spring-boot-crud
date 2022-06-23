package com.example.springbootcrud.controller;

import com.example.springbootcrud.dto.Employee;
import com.example.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CrudController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId ){
        Optional<Employee> employee= employeeService.getEmployee(empId);
        if(employee.isPresent())
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees=employeeService.getAllEmployee();
        return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
    }
    @PostMapping("/emp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee emp= employeeService.createEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
    }
    @PutMapping("/emp")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee emp= employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") int empId ){
        employeeService.deleteEmployee(empId);
        return "Employee with id : "+ empId+" is deleted";
    }

}
