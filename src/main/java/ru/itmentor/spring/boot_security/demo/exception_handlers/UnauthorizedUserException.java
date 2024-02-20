package ru.itmentor.spring.boot_security.demo.exception_handlers;

public class UnauthorizedUserException extends RuntimeException {

    public UnauthorizedUserException(String message) {
        super(message);
    }
}
