package com.samet.student_management_system.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timeStamp;

    public StudentErrorResponse() {

    }

    public StudentErrorResponse(String message, int status, LocalDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
