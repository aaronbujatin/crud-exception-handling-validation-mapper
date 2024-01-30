package com.aaronbujatin.jpapractice.exception;

public class StudentEmailAlreadyExistException extends RuntimeException{

    public StudentEmailAlreadyExistException(String message) {
        super(message);
    }
}
