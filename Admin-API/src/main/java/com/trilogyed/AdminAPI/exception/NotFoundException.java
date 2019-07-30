package com.trilogyed.AdminAPI.exception;

public class NotFoundException extends Throwable {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
