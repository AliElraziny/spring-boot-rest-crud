package com.try2code.demo.rest;

import com.try2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents  ;
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("ali","ahmed"));
        theStudents.add(new Student("samy","adham"));
        theStudents.add(new Student("mohamed","mohamed"));

    }

    //define end point /student to retrieve list of student

    @GetMapping("/student")
    public List<Student> getStudent(){
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

       if(studentId>theStudents.size() || studentId<0){
            throw new StudentNotFoundException("Student not found "+studentId);
        }
        return theStudents.get(studentId);
    }


}
