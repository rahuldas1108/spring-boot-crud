package com.example.springbootcrud.controller;

import com.example.springbootcrud.dto.Employee;
import com.example.springbootcrud.exception.NotFoundException;
import com.example.springbootcrud.service.EmployeeService;
import com.example.springbootcrud.service.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CrudController {
    private static final Logger logger = LoggerFactory.getLogger(CrudController.class);
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId ) throws NotFoundException {
        logger.info("Sending request to service layer");
        Optional<Employee> employee = employeeService.getEmployee(empId);
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }
    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> getEmployees(){
        logger.info("Sending request to service layer");
        List<Employee> employees=employeeService.getAllEmployee();
        return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
    }
    @PostMapping("/emp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        logger.info("Sending request to service layer");
        Employee emp= employeeService.createEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
    }
    @PutMapping("/emp")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws NotFoundException {
        logger.info("Sending request to service layer");
        Employee emp= employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") int empId ) throws NotFoundException {
        logger.info("Sending request to service layer");
        employeeService.deleteEmployee(empId);
        return "Employee with id : "+ empId+" is deleted";
    }

}
