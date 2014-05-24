package com.hairCustomer.management.Exception;

public class WrongLoginInfoException extends RuntimeException {
    public WrongLoginInfoException() {
        super();
    }
    public WrongLoginInfoException(String exceptionMsg) {
        super(exceptionMsg);
    }
}
