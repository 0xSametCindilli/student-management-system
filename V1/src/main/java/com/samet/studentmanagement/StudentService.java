package com.samet.studentmanagement;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }

    // Read
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    // ReadId
    public Student getStudentById(Long id) {

        return studentRepository.findById(id).orElse(null);
    }

    // Update
    public Student updateStudent(Long id, Student newStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail(newStudent.getEmail());

        return studentRepository.save(student);
    }


    // Delete

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
