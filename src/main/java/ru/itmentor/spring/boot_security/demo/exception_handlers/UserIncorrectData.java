package ru.itmentor.spring.boot_security.demo.exception_handlers;

public class UserIncorrectData{

    public String message;

    public UserIncorrectData() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
