package com.trilogy.LevelUpQueueConsumer.exception;

public class NotFoundException extends RuntimeException {
    /*
     * Exception class to handle not found cases in get APIs.
     * A not found exception will be handle by the controllerHandleException,
     * to return a 404 status code.
     */
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
//        message.toString();

    }
}