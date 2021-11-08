package com.ileiwe.service.exception;

import org.springframework.context.annotation.Bean;


public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(String s) {
        super(s);
    }
}
