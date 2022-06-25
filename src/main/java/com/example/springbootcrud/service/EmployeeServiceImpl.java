package com.example.springbootcrud.service;

import com.example.springbootcrud.dto.Employee;
import com.example.springbootcrud.exception.NotFoundException;
import com.example.springbootcrud.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(cacheNames ="employee" ,key = "#empId")
    public Optional<Employee> getEmployee(int empId) throws NotFoundException {
        logger.info("Sending request to database to fetch data");
        Optional<Employee> emp = employeeRepository.findById(empId);
        if(emp.isPresent()) {
            return emp;
        }
        else
            throw new NotFoundException("Employee with id : "+ empId+" is not found");
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @CachePut(cacheNames = "employee", key = "#employee.id")
    public Employee updateEmployee(Employee employee) throws NotFoundException {
        int id=employee.getId();
        logger.info("Sending request to database to verify id");
       Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()) {
            logger.info("Sending request to database to update details");
            employeeRepository.updateEmployeeDetails(employee.getCity(), employee.getPhoneNo(), id);
            logger.info("Employee with id : {} is updated",id);
            return employee;
        }
        else{
            throw new NotFoundException("Employee with id : "+ id+" is not found");
        }
    }

    @Override
    @CacheEvict(cacheNames = "employee" , key = "#empId")
    public void deleteEmployee(int empId) throws NotFoundException {
        logger.info("Sending request to database to verify id");
        Optional<Employee> emp = employeeRepository.findById(empId);
        if(emp.isPresent()){
            logger.info("Sending request to database to delete");
            employeeRepository.deleteById(empId);
            logger.info("Employee with id : {} is deleted",empId);
        }
        else
            throw new NotFoundException("Employee with id : "+ empId+" is not found");

    }
}
