package com.example.demo.service;

import com.example.demo.bean.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList();

    Integer updateByNo(String no, Integer age);

    Student getStudentByNo(String no);
}
