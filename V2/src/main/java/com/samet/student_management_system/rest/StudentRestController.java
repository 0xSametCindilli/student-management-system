package com.samet.student_management_system.rest;

import com.samet.student_management_system.entity.Student;
import com.samet.student_management_system.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }



    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findOne(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/students")
    public Student save(@RequestBody Student student) {
        student.setId(null);
        return studentService.save(student);
    }

    @PutMapping("/students/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }

}
