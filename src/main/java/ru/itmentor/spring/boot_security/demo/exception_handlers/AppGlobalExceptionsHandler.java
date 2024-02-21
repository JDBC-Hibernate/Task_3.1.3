package ru.itmentor.spring.boot_security.demo.exception_handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppGlobalExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> exceptionHandler(
            NoSuchUserException exception) {
        UserIncorrectData data = new UserIncorrectData();
        data.setMessage(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> exceptionHandler(
            UnauthorizedUserException exception) {
        UserIncorrectData data = new UserIncorrectData();
        data.setMessage(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> exceptionHandler(
            Exception exception) {
        UserIncorrectData data = new UserIncorrectData();
        data.setMessage(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
