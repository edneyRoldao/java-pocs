package com.feignstudy.demo.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

}
