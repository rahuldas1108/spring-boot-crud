package com.example.springbootcrud.service;

import java.util.Map;

public class StudentReflection {

    private StudentMap studentMap;

    public StudentReflection(StudentMap studentMap) {
        this.studentMap = studentMap;
    }

    public String validateStudents(String studentId) {
        Map<String, String> students = studentMap.getStudents();
        return students.get(studentId);
    }

    private String validateStudentsStream(String studentName){
        if(studentName.equalsIgnoreCase("Rahul"))
            return "Science";
        else
            return "Arts";
    }
}
