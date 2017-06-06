package com.email.traning.exception;

/**
 * Created by Pasha on 06.06.2017.
 */
public class ObjectExistException extends RuntimeException {
    public ObjectExistException() {
    }

    public ObjectExistException(String message) {
        super(message);
    }

    public ObjectExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectExistException(Throwable cause) {
        super(cause);
    }

    public ObjectExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
