package com.example.springbootcrud.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name="EmployeeID")
    private int id;
    @Column(name="Name")
    private String name;
    @Column(name="City")
    private String city;
    @Column(name="Salary")
    private float salary;
    @Column(name="PhoneNumber")
    private String phoneNo;

    public Employee() {
    }

    public Employee(int id, String name, String city, float salary, String phoneNo) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Float.compare(employee.salary, salary) == 0 && name.equals(employee.name) && Objects.equals(city, employee.city) && phoneNo.equals(employee.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, salary, phoneNo);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
