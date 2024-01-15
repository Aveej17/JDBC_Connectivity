package com.StudentDB.myProject.controller;


import com.StudentDB.myProject.Student;
import com.StudentDB.myProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/getStudents")
    public List<Student> getStudents(Student student) throws SQLException {
        return studentService.getStudents(student);
    }

//    @PostMapping("/insertStudents")
//    public int insertStudents(@RequestBody Student student) throws Exception {
//        return studentService.insertStudents(student);
//    }

    @PostMapping("/insertStudents")
    public ResponseEntity<Integer> insertStudents(@RequestBody Student student) throws Exception {
        if (student.getSName() == null)
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
         return new ResponseEntity<>(studentService.insertStudents(student), HttpStatus.OK);
    }

    @PutMapping("/updateStudents")
    public int updateStudent(@RequestBody Student student) throws SQLException {
        return studentService.updateStudent(student);
    }



    @PostMapping("/deleteStudents")
    public String deleteStudents(@RequestParam int sId ) throws SQLException {
        return studentService.deleteStudents(sId);
    }

}
