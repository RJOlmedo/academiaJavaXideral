package com.rickyolmedo.studentsystem.service;

import com.rickyolmedo.studentsystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}