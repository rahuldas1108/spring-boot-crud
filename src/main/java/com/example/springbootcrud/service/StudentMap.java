package com.example.springbootcrud.service;

import java.util.HashMap;
import java.util.Map;

public class StudentMap {

    Map<String,String> students=new HashMap<>();


    public Map<String, String> getStudents() {
        students.put("A","Rahul");
        students.put("B","abcd");
        /*String s = students.get(studentId);*/
        return students;
    }

}
