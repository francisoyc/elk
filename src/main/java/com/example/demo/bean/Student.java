package com.example.demo.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;
    private String no;
    private String name;
    private Integer age;
   // @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
