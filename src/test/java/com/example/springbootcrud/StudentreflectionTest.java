package com.example.springbootcrud;

import com.example.springbootcrud.service.StudentMap;
import com.example.springbootcrud.service.StudentReflection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ExtendWith(MockitoExtension.class)
public class StudentreflectionTest {
    StudentMap studentMap=new StudentMap();
    StudentReflection reflection =new StudentReflection(studentMap);
    @Test
    void validate() throws NoSuchFieldException, IllegalAccessException {

        StudentReflection studentReflection=new StudentReflection(studentMap);//class for which test cases is written
        //private field which is StudentMap object;
        ReflectionTestUtils.setField(studentReflection,"studentMap",studentMap,StudentMap.class);
        String a = studentReflection.validateStudents("A");
        Assertions.assertEquals("Rahul",a);

    }
    @Test
    void validateStream() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method=reflection.getClass().getDeclaredMethod("validateStudentsStream",String.class);
        method.setAccessible(true);
        String rahul = (String)method.invoke(reflection, "Rahul");
        Assertions.assertEquals("Science",rahul);
    }

}
