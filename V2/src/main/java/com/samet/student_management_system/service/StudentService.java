package com.samet.student_management_system.service;

import com.samet.student_management_system.entity.Student;

import java.util.List;

public interface StudentService  {

    List<Student> findAll();
    Student findById(Long id);
    Student save(Student student);
    void deleteById(Long id);

}
