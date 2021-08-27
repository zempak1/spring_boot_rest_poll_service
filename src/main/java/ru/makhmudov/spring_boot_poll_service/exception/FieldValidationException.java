package ru.makhmudov.spring_boot_poll_service.exception;

public class FieldValidationException extends RuntimeException {

    public FieldValidationException(String message) {
        super(message);
    }
}
