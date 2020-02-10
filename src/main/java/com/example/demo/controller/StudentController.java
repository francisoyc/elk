package com.example.demo.controller;

import com.example.demo.annotation.RoleAuth;
import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping("/query")
    @RoleAuth(value = {"admin", "super"})
    public Student query(Student stu) {
        log.info("all students = {}", service.getStudentList());
        log.debug("update num = {}", service.updateByNo(stu.getNo(), stu.getAge()));
        Student student = service.getStudentByNo(stu.getNo());
        log.error("student = {}", student);
        return student;
    }

    @GetMapping("/error")
    public String error() {
        try {
            int i = 1/0;
        } catch (Exception e) {
            // 不建议直接e.printStackTrace()，日志拦截不到
           log.info("=======", e);
        }
        Student student = null;
        System.out.println("===========================" + student.getName());
        return "ok";
    }
}
