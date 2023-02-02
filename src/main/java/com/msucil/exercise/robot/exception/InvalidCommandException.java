package com.msucil.exercise.robot.exception;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String message){
        super(message);
    }
}
