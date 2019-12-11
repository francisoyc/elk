package com.example.demo.service.impl;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    @Override
    public Integer updateByNo(String no, Integer age) {
        return studentDao.updateByNo(no, age);
    }

    @Override
    public Student getStudentByNo(String no) {
        return studentDao.getStudentByNo(no);
    }

}
