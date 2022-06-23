package com.example.springbootcrud.service;

import com.example.springbootcrud.dto.Employee;
import com.example.springbootcrud.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> getEmployee(int empId) {
        return employeeRepository.findById(empId);
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
    public Employee updateEmployee(Employee employee) {
        int id=employee.getId();
       Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent())
            employeeRepository.updateEmployeeDetails(employee.getCity(), employee.getPhoneNo(),id);
        return employee;
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeRepository.deleteById(empId);
        logger.info("Employee with id : {} is deleted",empId);
    }
}
