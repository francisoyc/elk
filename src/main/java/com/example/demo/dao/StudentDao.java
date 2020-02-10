package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    @Select("select * from student")
    List<Student> getStudentList();

    @Update("update student set age = #{age} where no=#{no}")
    Integer updateByNo(@Param("no") String no, @Param("age")Integer age);

    @Select("select * from student where no=#{no}")
    Student getStudentByNo(@Param("no") String no);
}
