package com.StudentDB.myProject.repository;

import com.StudentDB.myProject.Student;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private Connection connection;

    public StudentRepository(Connection connection) throws SQLException {
        this.connection = connection;
        createTable();

    }

    public List<Student> getStudents(Student student) throws SQLException {
        List<Student> list = new ArrayList<>();
        ResultSet set = connection.createStatement().executeQuery("select * from student");
        while(set.next()){
            Student s = new Student(set.getString("sName"), set.getInt("sId"), set.getInt("mathMarks"), set.getInt("scienceMarks"));
            list.add(s);
        }
        return list;
    }

    public int insertStudents(Student student) throws Exception {
//        String k = student.getSName();
//        int id = student.getSId();
//        int mm = student.getMathMarks();
//        int sm = student.getScienceMarks();
//        System.out.println(k+id+" "+mm+" "+sm);
        if (student.getSName() == null) {
            throw new Exception("Name should not be null");
        }
        return connection.createStatement().executeUpdate("insert into student (sName, sId, mathMarks, scienceMarks) Values('"+student.getSName()+"','"+student.getSId()+"','"+student.getMathMarks()+"','"+student.getScienceMarks()+"')");
    }

    public String deleteStudents(int sId) throws SQLException {
            int res = connection.createStatement().executeUpdate("DELETE FROM student WHERE sId= '"+sId+"'");
            String returnStatement;
            if (res == 1){
                returnStatement = "entry Deleted";
            }
            else{
                returnStatement = "No value to delete";
            }
            return returnStatement;
    }

    public int updateStudent(Student student) throws SQLException {
        int res = connection.createStatement().executeUpdate("UPDATE student\n" +
                "SET sName= '"+student.getSName()+"'\n" +
                "WHERE SId='"+student.getSId()+"'");
        return 1;
    }

    public void createTable() throws SQLException {
        connection.createStatement().execute("create table if not exists student(sName varchar(25), sId int, mathMarks int, scienceMarks int);");
    }



}
