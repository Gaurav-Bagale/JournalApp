package com.gaurav.JournalApp.advices;


import java.time.LocalDateTime;


public class ErrorMessage {

    private int errorCode;

    private String message;

    private LocalDateTime timeStamp;

    public ErrorMessage(int errorCode, String message, LocalDateTime timeStamp) {
        this.errorCode = errorCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ErrorMessage() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
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
}
