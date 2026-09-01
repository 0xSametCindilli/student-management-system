package com.samet.student_management_system.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException e) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage("Invalid request format or parameter. Please check your input.");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
