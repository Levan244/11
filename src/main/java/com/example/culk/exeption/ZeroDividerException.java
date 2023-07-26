package com.example.culk.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ZeroDividerException extends RuntimeException{
    public ZeroDividerException() {
        super("На 0 делить нельзя!");
    }
}
