package com.StudentDB.myProject.service;

import com.StudentDB.myProject.Student;
import com.StudentDB.myProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudents(Student student) throws SQLException {
        return studentRepository.getStudents(student);
    }

    public int insertStudents(Student student) throws Exception {
        return studentRepository.insertStudents(student);
    }

    public int updateStudent(Student student) throws SQLException {
        return studentRepository.updateStudent(student);
    }

    public String deleteStudents(int  sId) throws SQLException {
        return studentRepository.deleteStudents(sId);
    }


}
