package com.example.springbootcrud.repository;

import com.example.springbootcrud.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    //Employee save();
    @Transactional
    @Modifying
    @Query("update Employee e set e.city=?1 , e.phoneNo=?2 where e.id=?3")
    void updateEmployeeDetails(String city, String phoneNo, int id);
}
