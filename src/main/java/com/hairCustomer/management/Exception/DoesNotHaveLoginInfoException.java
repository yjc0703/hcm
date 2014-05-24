package com.hairCustomer.management.Exception;

/**
 * Created by asus-kry on 2014-05-24.
 */
public class DoesNotHaveLoginInfoException extends RuntimeException {
    public DoesNotHaveLoginInfoException() {
        super();
    }

    public DoesNotHaveLoginInfoException(String errMsg) {
        super(errMsg);
    }
}
