package com.students;
import db.DbConnection;
import models.Student;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        DbConnection db = new DbConnection();
        ArrayList<Student> students = db.getStudents();
        for (Student student : students) {
            System.out.println(student);
            System.out.println("===================================");
        }
    }
}
