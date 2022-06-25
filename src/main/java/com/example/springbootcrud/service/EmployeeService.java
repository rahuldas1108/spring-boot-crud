package com.example.springbootcrud.service;

import com.example.springbootcrud.dto.Employee;
import com.example.springbootcrud.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> getEmployee(int empId) throws NotFoundException;

    List<Employee> getAllEmployee();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee) throws NotFoundException;

    void deleteEmployee(int empId) throws NotFoundException;
}
